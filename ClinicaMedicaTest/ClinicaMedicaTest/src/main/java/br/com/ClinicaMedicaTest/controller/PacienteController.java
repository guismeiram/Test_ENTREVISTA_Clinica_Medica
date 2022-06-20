package br.com.ClinicaMedicaTest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ClinicaMedicaTest.dto.MedicoDTO;
import br.com.ClinicaMedicaTest.dto.PacienteDTO;
import br.com.ClinicaMedicaTest.model.Medico;
import br.com.ClinicaMedicaTest.model.Paciente;
import br.com.ClinicaMedicaTest.service.MedicoService;
import br.com.ClinicaMedicaTest.service.PacienteService;

public class PacienteController {
	@Autowired
	private final PacienteService pacienteService;
	
	 @Autowired
	 private ModelMapper modelMapper;
	 
	 public PacienteController(PacienteService pacienteService, ModelMapper modelMapper) {
		 this.pacienteService = pacienteService;
		 this.modelMapper = modelMapper;
	 }
	
	 	@PostMapping
	    public ResponseEntity<PacienteDTO> createPaciente(@RequestBody PacienteDTO pacienteDTO) {
	        // convert DTO to entity
	        Paciente pacienteRequest = modelMapper.map(pacienteDTO, Paciente.class);

	        Paciente paciente = pacienteService.createPaciente(pacienteRequest);

	        // convert entity to DTO
	        PacienteDTO pacienteResponse = modelMapper.map(paciente, PacienteDTO.class);

	        return new ResponseEntity<PacienteDTO>(pacienteResponse, HttpStatus.CREATED);
	    }
	///////
	
	
	
	
	 @GetMapping
	    public List<PacienteDTO> getAllMedicos() {

	        return pacienteService.findAll().stream().map(post -> modelMapper.map(post, PacienteDTO.class))
	                .collect(Collectors.toList());
	    }
}
