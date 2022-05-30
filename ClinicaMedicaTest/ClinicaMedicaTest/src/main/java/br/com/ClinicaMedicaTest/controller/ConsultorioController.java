package br.com.ClinicaMedicaTest.controller;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ClinicaMedicaTest.dto.ConsultorioDTO;
import br.com.ClinicaMedicaTest.form.ConsultorioFORM;
import br.com.ClinicaMedicaTest.model.Consultorio;
import br.com.ClinicaMedicaTest.repository.ConsultorioRepository;
import br.com.ClinicaMedicaTest.repository.MedicoRepository;

@RestController
@RequestMapping("/consultorio")
public class ConsultorioController {

	@Autowired
	private ConsultorioRepository consultorioRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	

	//create
	@PostMapping
	@Transactional
	public ResponseEntity<ConsultorioDTO> cadastrar(@RequestBody ConsultorioFORM form, UriComponentsBuilder uriBuilder) {
		Consultorio consultorio = form.converter(medicoRepository);
		consultorioRepository.save(consultorio);
		
		URI uri = uriBuilder.path("/consultorios/{id}").buildAndExpand(consultorio.getId()).toUri();
		return ResponseEntity.created(uri).body(new ConsultorioDTO(consultorio));
	}
    
	
}
