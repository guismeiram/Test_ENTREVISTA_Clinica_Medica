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

import br.com.ClinicaMedicaTest.dto.MedicoDTO;
import br.com.ClinicaMedicaTest.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {
	
	private final MedicoService medicoService;
	
	
	@Autowired
	public MedicoController(MedicoService medicoService) {
		this.medicoService = medicoService;
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
}
