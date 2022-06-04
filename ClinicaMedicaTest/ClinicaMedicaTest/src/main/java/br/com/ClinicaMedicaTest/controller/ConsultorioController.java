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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ClinicaMedicaTest.dto.ConsultorioDTO;
import br.com.ClinicaMedicaTest.dto.MedicoDTO;
import br.com.ClinicaMedicaTest.service.ConsultorioService;

@RestController
@RequestMapping("/consultorio")
public class ConsultorioController {
	
	private final ConsultorioService consultorioService;
	private final PagedResourcesAssembler<ConsultorioDTO> assembler;

	
	@Autowired
	public ConsultorioController(ConsultorioService consultorioService, PagedResourcesAssembler<ConsultorioDTO> assembler) {
		this.consultorioService = consultorioService;
		this.assembler = assembler;
	}
	

	
	@PostMapping(produces = {"application/json","application/xml","application/x-yaml"}, 
		     consumes = {"application/json","application/xml","application/x-yaml"})
	public ConsultorioDTO create(@RequestBody ConsultorioDTO consultorioDTO) {
		ConsultorioDTO proDTO = consultorioService.create(consultorioDTO);
		proDTO.add(linkTo(methodOn(ConsultorioController.class).findById(proDTO.getId())).withSelfRel());
		return proDTO;
	}
	
	@GetMapping(value = "/{id}", produces = {"application/json","application/xml","application/x-yaml"})
	public ConsultorioDTO findById(@PathVariable("id")  Long id) {
		ConsultorioDTO consultorioVO = consultorioService.findById(id);
		consultorioVO.add(linkTo(methodOn(ConsultorioController.class).findById(id)).withSelfRel());
		return consultorioVO;
	}
	
	@GetMapping(produces = {"application/json","application/xml","application/x-yaml"})
	public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "12") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction) {
		
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page,limit, Sort.by(sortDirection,"nome"));
		
		Page<ConsultorioDTO> consultorio = consultorioService.findAll(pageable);
		
		consultorio.stream()
				.forEach(p -> p.add(linkTo(methodOn(ConsultorioController.class).findById(p.getId())).withSelfRel()));
		
		PagedModel<EntityModel<ConsultorioDTO>> pagedModel = assembler.toModel(consultorio);
		
		return new ResponseEntity<>(pagedModel,HttpStatus.OK);
	}
	
}
