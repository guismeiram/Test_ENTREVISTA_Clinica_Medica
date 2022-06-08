package br.com.ClinicaMedicaTest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.modelmapper.Converters.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ClinicaMedicaTest.dto.ConsultaDTO;
import br.com.ClinicaMedicaTest.dto.MedicoDTO;
import br.com.ClinicaMedicaTest.model.Consulta;
import br.com.ClinicaMedicaTest.service.ConsultaService;



@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {
	
	@Autowired
	private final ConsultaService consultaService;
	
	 @Autowired
	private ModelMapper mapper;
	 
	 public ConsultaController(ConsultaService consultaService, ModelMapper mapper) {
			this.consultaService = consultaService;
			this.mapper = mapper;
		}
	 
	 
	
     
	 	/*@PostMapping
	    //@ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<ConsultaDTO> createConsulta(@RequestBody ConsultaDTO consultaDTO) {
	 		
	 		 // convert DTO to entity
	        Consulta consultaRequest = modelMapper.map(consultaDTO, Consulta.class);

	        Consulta consulta = consultaService.createConsulta(consultaRequest);

	        // convert entity to DTO
	        ConsultaDTO consultaResponse = modelMapper.map(consulta, ConsultaDTO.class);

	        return new ResponseEntity<ConsultaDTO>(consultaResponse, HttpStatus.CREATED);	 	
	        }*/
     
	 
}
