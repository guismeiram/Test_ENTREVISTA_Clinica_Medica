package br.com.ClinicaMedicaTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ClinicaMedicaTest.dto.ConsultorioDTO;
import br.com.ClinicaMedicaTest.dto.MedicoDTO;
import br.com.ClinicaMedicaTest.exception.ResourceNotFoundException;
import br.com.ClinicaMedicaTest.model.Consultorio;
import br.com.ClinicaMedicaTest.model.Medico;
import br.com.ClinicaMedicaTest.repository.ConsultorioRepository;

@Service
public class ConsultorioService {
	
	private final ConsultorioRepository consultorioRepository;

	
	@Autowired
	public ConsultorioService(ConsultorioRepository consultorioRepository) {
		this.consultorioRepository = consultorioRepository;
	}
	
	public List<Consultorio> findAll() {
        return consultorioRepository.findAll();

	}
	
	public Consultorio createConsultorio(Consultorio consultorio) {
        return consultorioRepository.save(consultorio);
    }
	
	
	
}
