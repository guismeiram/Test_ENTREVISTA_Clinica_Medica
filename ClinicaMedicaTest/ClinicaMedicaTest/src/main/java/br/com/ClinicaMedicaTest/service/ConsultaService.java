package br.com.ClinicaMedicaTest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ClinicaMedicaTest.dto.ConsultaDTO;
import br.com.ClinicaMedicaTest.dto.ConsultorioDTO;
import br.com.ClinicaMedicaTest.exception.ResourceNotFoundException;
import br.com.ClinicaMedicaTest.model.Consulta;
import br.com.ClinicaMedicaTest.model.Consultorio;
import br.com.ClinicaMedicaTest.model.Medico;
import br.com.ClinicaMedicaTest.repository.ConsultaRepository;

@Service
public class ConsultaService {
	
	private final ConsultaRepository consultaRepository;

	
	@Autowired
	public ConsultaService(ConsultaRepository consultaRepository) {
		this.consultaRepository = consultaRepository;
	}
	
	@Transactional
	 public Consulta createConsulta(Consulta consulta) {

	        return consultaRepository.save(consulta);

	    }

	public Consulta getById(Long id) {
		// TODO Auto-generated method stub
		return consultaRepository.getById(id);
	}
	
}
