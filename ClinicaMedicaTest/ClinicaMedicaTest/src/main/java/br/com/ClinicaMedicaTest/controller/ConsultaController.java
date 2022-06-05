package br.com.ClinicaMedicaTest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ClinicaMedicaTest.dto.ConsultaDTO;
import br.com.ClinicaMedicaTest.dto.ConsultorioDTO;
import br.com.ClinicaMedicaTest.model.Consulta;
import br.com.ClinicaMedicaTest.model.Consultorio;
import br.com.ClinicaMedicaTest.model.Medico;
import br.com.ClinicaMedicaTest.service.ConsultaService;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {
	
	private final ConsultaService consultaService;
	private final PagedResourcesAssembler<ConsultaDTO> assembler;
	private ModelMapper mapper;

	
	@Autowired
	public ConsultaController(ConsultaService consultaService, PagedResourcesAssembler<ConsultaDTO> assembler) {
		this.consultaService = consultaService;
		this.assembler = assembler;
	}
	
	 	@PostMapping
	    //@ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<ConsultaDTO> createConsulta(@RequestBody ConsultaDTO consultaDTO) {
	 		
	 		Consulta consultaResp = geraConsultaConsultorio();
	 		consultaResp = geraConsultaMedico();

	 		consultaDTO = geraConsultaMedicoDTO();
	 	    consultaDTO = geraConsultaConsultorioDTO();
	 	    
		    consultaResp =  mapper.map(consultaDTO, Consulta.class);

		    Consulta consultaPoint = consultaService.createConsulta(consultaResp);

			
			consultaDTO = mapper.map(consultaPoint, ConsultaDTO.class);
			
	 		
	        return new ResponseEntity<ConsultaDTO>(consultaDTO, HttpStatus.CREATED);	 	
	        }
	
	 	private ConsultaDTO geraConsultaConsultorioDTO() {
	 		List<Consultorio> consultorio = new ArrayList<Consultorio>();
			ConsultaDTO dto = new ConsultaDTO();
			dto.setConsultorio(consultorio);
			
			return dto;
		}
		
		private ConsultaDTO geraConsultaMedicoDTO() {
			List<Medico> medico = new ArrayList<Medico>();
			ConsultaDTO dto = new ConsultaDTO();
			dto.setMedico(medico);
			
			return dto;
		}
	 	
	 	private Consulta geraConsultaConsultorio() {
			
			Consultorio consultorio = new Consultorio();
			Consulta consulta = new Consulta();
			consulta.setAdicionaConsultorio(consultorio);
			
			return consulta;
		}

		private Consulta geraConsultaMedico() {
			Medico medico = new Medico();
			Consulta consulta = new Consulta();
			consulta.setAdicionaMedico(medico);
			
			return consulta;
		}
}
