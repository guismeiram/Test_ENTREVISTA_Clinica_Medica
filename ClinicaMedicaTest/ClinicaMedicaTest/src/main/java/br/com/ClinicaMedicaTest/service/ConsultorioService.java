package br.com.ClinicaMedicaTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ClinicaMedicaTest.dto.ConsultorioDTO;
import br.com.ClinicaMedicaTest.exception.ResourceNotFoundException;
import br.com.ClinicaMedicaTest.model.Consultorio;
import br.com.ClinicaMedicaTest.repository.ConsultorioRepository;

@Service
public class ConsultorioService {
	
	private final ConsultorioRepository consultorioRepository;

	
	@Autowired
	public ConsultorioService(ConsultorioRepository consultorioRepository) {
		this.consultorioRepository = consultorioRepository;
	}



	public List<Consultorio> listaConsultorio(){
		return consultorioRepository.findAll();
	}
	

	public Consultorio listaConsultorioUnico(long id){
		return consultorioRepository.findById(id);
	}
	

	public ConsultorioDTO create(ConsultorioDTO consultorioDTO) {
		ConsultorioDTO proDtoRetorno = ConsultorioDTO.create(consultorioRepository.save(Consultorio.create(consultorioDTO)));
		return proDtoRetorno;
		
	}
	
	
	public ConsultorioDTO findById(Long id) {
		Consultorio entity = consultorioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return ConsultorioDTO.create(entity);
	}
}
