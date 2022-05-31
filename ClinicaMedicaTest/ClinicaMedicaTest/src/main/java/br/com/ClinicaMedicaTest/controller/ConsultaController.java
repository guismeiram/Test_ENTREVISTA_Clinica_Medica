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

import br.com.ClinicaMedicaTest.dto.ConsultaDTO;
import br.com.ClinicaMedicaTest.form.ConsultaFORM;
import br.com.ClinicaMedicaTest.model.Consulta;
import br.com.ClinicaMedicaTest.model.Consultorio;
import br.com.ClinicaMedicaTest.repository.ConsultaRepository;
import br.com.ClinicaMedicaTest.repository.ConsultorioRepository;
import br.com.ClinicaMedicaTest.repository.PessoaRepository;

@RestController
@RequestMapping("/consultorio")
public class ConsultaController {

	@Autowired
	private ConsultorioRepository consultorioRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private ConsultaRepository consultaRepository;
	
	//create
	@PostMapping
	@Transactional
	public ResponseEntity<ConsultaDTO> cadastrar(@RequestBody ConsultaFORM form, UriComponentsBuilder uriBuilder) {
		Consulta consulta = form.converter(pessoaRepository, consultorioRepository);
		consultaRepository.save(consulta);
		
		URI uri = uriBuilder.path("/consultorios/{id}").buildAndExpand(consulta.getId()).toUri();
		return ResponseEntity.created(uri).body(new ConsultaDTO(consulta));
	}
    
	
}
