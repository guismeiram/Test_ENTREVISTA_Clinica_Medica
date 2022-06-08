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
import org.springframework.web.bind.annotation.CrossOrigin;
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
import br.com.ClinicaMedicaTest.model.Medico;
import br.com.ClinicaMedicaTest.service.MedicoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/medico")
@CrossOrigin("*")
@AllArgsConstructor

public class MedicoController {
	
	private final MedicoService medicoService;
	
	 @Autowired
	 private ModelMapper modelMapper;

	
	 	@PostMapping
	    public ResponseEntity<MedicoDTO> createMedico(@RequestBody MedicoDTO medicoDTO) {
	        // convert DTO to entity
	        Medico medicoRequest = modelMapper.map(medicoDTO, Medico.class);

	        Medico medico = medicoService.createMedico(medicoRequest);

	        // convert entity to DTO
	        MedicoDTO medicoResponse = modelMapper.map(medico, MedicoDTO.class);

	        return new ResponseEntity<MedicoDTO>(medicoResponse, HttpStatus.CREATED);
	    }
	
	
	
	
	
	 @GetMapping
	    public List<MedicoDTO> getAllMedicos() {

	        return medicoService.findAll().stream().map(post -> modelMapper.map(post, MedicoDTO.class))
	                .collect(Collectors.toList());
	    }
	
}
