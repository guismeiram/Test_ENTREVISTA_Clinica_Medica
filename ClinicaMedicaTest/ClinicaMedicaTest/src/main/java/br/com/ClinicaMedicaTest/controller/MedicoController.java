package br.com.ClinicaMedicaTest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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

import br.com.ClinicaMedicaTest.dto.MedicoDTO;
import br.com.ClinicaMedicaTest.service.MedicoService;

@RestController
@RequestMapping("/api/medico")
public class MedicoController {
	
	private final MedicoService medicoService;
	private final PagedResourcesAssembler<MedicoDTO> assembler;
	
	 @Autowired
	 private ModelMapper modelMapper;

	
	
	@Autowired
	public MedicoController(MedicoService medicoService, PagedResourcesAssembler<MedicoDTO> assembler) {
		this.medicoService = medicoService;
		this.assembler = assembler;
	}
	

	
	@PostMapping(produces = {"application/json","application/xml","application/x-yaml"}, 
		     consumes = {"application/json","application/xml","application/x-yaml"})
	public MedicoDTO create(@RequestBody MedicoDTO medicoDTO) {
		MedicoDTO proDTO = medicoService.create(medicoDTO);
		proDTO.add(linkTo(methodOn(MedicoController.class).findById(proDTO.getId())).withSelfRel());
		return proDTO;
	}
	
	@GetMapping(value = "/{id}", produces = {"application/json","application/xml","application/x-yaml"})
	public MedicoDTO findById(@PathVariable("id")  Long id) {
		MedicoDTO medicoVO = medicoService.findById(id);
		medicoVO.add(linkTo(methodOn(MedicoController.class).findById(id)).withSelfRel());
		return medicoVO;
	}
	
	 @GetMapping
	    public List<MedicoDTO> getAllImovels() {

	        return medicoService.findAll().stream().map(post -> modelMapper.map(post, MedicoDTO.class))
	                .collect(Collectors.toList());
	    }
	
}
