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
import br.com.ClinicaMedicaTest.model.Consultorio;
import br.com.ClinicaMedicaTest.model.Medico;
import br.com.ClinicaMedicaTest.service.ConsultorioService;

@RestController
@RequestMapping("/api/consultorio")
public class ConsultorioController {
	
	private final ConsultorioService consultorioService;
	private final PagedResourcesAssembler<ConsultorioDTO> assembler;
	
	
	@Autowired
	public ConsultorioController(ConsultorioService consultorioService, PagedResourcesAssembler<ConsultorioDTO> assembler) {
		this.consultorioService = consultorioService;
		this.assembler = assembler;
	}
	

	 @Autowired
	 private ModelMapper modelMapper;

	
	 	@PostMapping
	    public ResponseEntity<ConsultorioDTO> createConsultorio(@RequestBody ConsultorioDTO consultorioDTO) {
	        // convert DTO to entity
	        Consultorio consultorioRequest = modelMapper.map(consultorioDTO, Consultorio.class);

	        Consultorio consultorio = consultorioService.createConsultorio(consultorioRequest);

	        // convert entity to DTO
	        ConsultorioDTO consultorioResponse = modelMapper.map(consultorio, ConsultorioDTO.class);

	        return new ResponseEntity<ConsultorioDTO>(consultorioResponse, HttpStatus.CREATED);
	    }
	
	 @GetMapping
	    public List<ConsultorioDTO> getAllMedicos() {

	        return consultorioService.findAll().stream().map(post -> modelMapper.map(post, ConsultorioDTO.class))
	                .collect(Collectors.toList());
	    }
	
	
}
