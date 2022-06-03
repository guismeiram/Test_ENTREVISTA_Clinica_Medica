package br.com.ClinicaMedicaTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ClinicaMedicaTest.dto.ConsultaDTO;
import br.com.ClinicaMedicaTest.exception.ResourceNotFoundException;
import br.com.ClinicaMedicaTest.model.Consulta;
import br.com.ClinicaMedicaTest.repository.ConsultaRepository;

@Service
public class ConsultaService {
	
	private final ConsultaRepository consultaRepository;

	
	@Autowired
	public ConsultaService(ConsultaRepository consultaRepository) {
		this.consultaRepository = consultaRepository;
	}



	public List<Consulta> listaConsultas(){
		return consultaRepository.findAll();
	}
	

	public Consulta listaConsultaUnico(long id){
		return consultaRepository.findById(id);
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
}
