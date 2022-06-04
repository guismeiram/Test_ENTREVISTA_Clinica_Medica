package br.com.ClinicaMedicaTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ClinicaMedicaTest.dto.ConsultaDTO;
import br.com.ClinicaMedicaTest.dto.ConsultorioDTO;
import br.com.ClinicaMedicaTest.exception.ResourceNotFoundException;
import br.com.ClinicaMedicaTest.model.Consulta;
import br.com.ClinicaMedicaTest.model.Consultorio;
import br.com.ClinicaMedicaTest.repository.ConsultaRepository;

@Service
public class ConsultaService {
	
	private final ConsultaRepository consultaRepository;

	
	@Autowired
	public ConsultaService(ConsultaRepository consultaRepository) {
		this.consultaRepository = consultaRepository;
	}
	

	public ConsultaDTO create(ConsultaDTO consultaDTO) {
		ConsultaDTO proDtoRetorno = ConsultaDTO.create(consultaRepository.save(Consulta.create(consultaDTO)));
		return proDtoRetorno;
		
	}
	
	
	public ConsultaDTO findById(Long id) {
		Consulta entity = consultaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return ConsultaDTO.create(entity);
	}
	
	public Page<ConsultaDTO> findAll(Pageable pageable) {
		var page = consultaRepository.findAll(pageable);
		return page.map(this::convertConsultaDTO);
	}

	
	private ConsultaDTO convertConsultaDTO(Consulta consulta) {
		return ConsultaDTO.create(consulta);
	}
}
