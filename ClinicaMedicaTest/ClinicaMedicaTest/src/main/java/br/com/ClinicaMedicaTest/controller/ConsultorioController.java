package br.com.ClinicaMedicaTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ClinicaMedicaTest.dto.ConsultorioDTO;
import br.com.ClinicaMedicaTest.service.ConsultorioService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping("/consultorio")
public class ConsultorioController {
	
	private final ConsultorioService consultorioService;
	
	
	@Autowired
	public ConsultorioController(ConsultorioService consultorioService) {
		this.consultorioService = consultorioService;
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
}
