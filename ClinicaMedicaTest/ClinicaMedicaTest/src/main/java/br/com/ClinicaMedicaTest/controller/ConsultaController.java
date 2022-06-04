package br.com.ClinicaMedicaTest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ClinicaMedicaTest.dto.ConsultaDTO;
import br.com.ClinicaMedicaTest.dto.ConsultorioDTO;
import br.com.ClinicaMedicaTest.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	
	private final ConsultaService consultaService;
	private final PagedResourcesAssembler<ConsultaDTO> assembler;

	
	@Autowired
	public ConsultaController(ConsultaService consultaService, PagedResourcesAssembler<ConsultaDTO> assembler) {
		this.consultaService = consultaService;
		this.assembler = assembler;
	}
	

	
	@PostMapping(produces = {"application/json","application/xml","application/x-yaml"}, 
		     consumes = {"application/json","application/xml","application/x-yaml"})
	public ConsultaDTO create(@RequestBody ConsultaDTO consultaDTO) {
		ConsultaDTO proDTO = consultaService.create(consultaDTO);
		proDTO.add(linkTo(methodOn(ConsultaController.class).findById(proDTO.getId())).withSelfRel());
		return proDTO;
	}
	
	@GetMapping(value = "/{id}", produces = {"application/json","application/xml","application/x-yaml"})
	public ConsultaDTO findById(@PathVariable("id")  Long id) {
		ConsultaDTO consultorioVO = consultaService.findById(id);
		consultorioVO.add(linkTo(methodOn(ConsultaController.class).findById(id)).withSelfRel());
		return consultorioVO;
	}
	
	@GetMapping(produces = {"application/json","application/xml","application/x-yaml"})
	public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "12") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction) {
		
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page,limit, Sort.by(sortDirection,"nome"));
		
		Page<ConsultaDTO> consulta = consultaService.findAll(pageable);
		
		consulta.stream()
				.forEach(p -> p.add(linkTo(methodOn(ConsultaController.class).findById(p.getId())).withSelfRel()));
		
		PagedModel<EntityModel<ConsultaDTO>> pagedModel = assembler.toModel(consulta);
		
		return new ResponseEntity<>(pagedModel,HttpStatus.OK);
	}
	
}
