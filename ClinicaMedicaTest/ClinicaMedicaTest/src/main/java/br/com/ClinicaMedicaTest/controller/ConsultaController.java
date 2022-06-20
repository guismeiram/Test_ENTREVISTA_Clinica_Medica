package br.com.ClinicaMedicaTest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.transaction.Transactional;

import org.modelmapper.Converters.Converter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ClinicaMedicaTest.dto.ConsultaDTO;
import br.com.ClinicaMedicaTest.dto.MedicoDTO;
import br.com.ClinicaMedicaTest.dto.PacienteDTO;
import br.com.ClinicaMedicaTest.model.Consulta;
import br.com.ClinicaMedicaTest.model.Paciente;
import br.com.ClinicaMedicaTest.service.ConsultaService;
import br.com.ClinicaMedicaTest.service.PacienteService;



@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {
	
	@Autowired
	private PacienteService pacienteService;
	
    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
	@Transactional
    public ConsultaDTO createConsulta(@RequestBody ConsultaDTO consultaDTO)
    {
    	Consulta consultaRequest = mapper.map(consultaDTO, Consulta.class);
        //consultorio
        consultaRequest.getConsultorio().forEach(consulta ->consulta.setNumero(consulta.getNumero()));
        consultaRequest.getConsultorio().forEach(consulta ->consulta.setData_hora(consulta.getData_hora()));
        //medico
        consultaRequest.getMedico().forEach(consulta ->consulta.setCrm(consulta.getCrm()));
        consultaRequest.getMedico().forEach(consulta ->consulta.setEspecialidade(consulta.getEspecialidade()));
        consultaRequest.getMedico().forEach(consulta ->consulta.setIdade(consulta.getIdade()));
        consultaRequest.getMedico().forEach(consulta ->consulta.setNome(consulta.getNome()));
        
       
        
        //Grava na Memoria
        Consulta consulta = consultaService.createConsulta(consultaRequest);
        // convert entity to DTO
        return mapper.map(consulta, ConsultaDTO.class);
    }

   
	 
}
