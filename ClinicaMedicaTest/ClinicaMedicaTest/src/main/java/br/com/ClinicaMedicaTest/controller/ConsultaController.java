package br.com.ClinicaMedicaTest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ClinicaMedicaTest.dto.ConsultaDTO;
import br.com.ClinicaMedicaTest.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	
	private final ConsultaService consultaService;
	
	
	@Autowired
	public ConsultaController(ConsultaService consultaService) {
		this.consultaService = consultaService;
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
}
