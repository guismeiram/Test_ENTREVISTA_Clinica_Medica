package br.com.ClinicaMedicaTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ClinicaMedicaTest.dto.MedicoDTO;
import br.com.ClinicaMedicaTest.exception.ResourceNotFoundException;
import br.com.ClinicaMedicaTest.model.Medico;
import br.com.ClinicaMedicaTest.repository.MedicoRepository;

@Service
public class MedicoService {
	
	private final MedicoRepository medicoRepository;

	
	@Autowired
	public MedicoService(MedicoRepository medicoRepository) {
		this.medicoRepository = medicoRepository;
	}

	public MedicoDTO create(MedicoDTO medicoDTO) {
		MedicoDTO proDtoRetorno = MedicoDTO.create(medicoRepository.save(Medico.create(medicoDTO)));
		return proDtoRetorno;
		
	}
	
	
	public MedicoDTO findById(Long id) {
		Medico entity = medicoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return MedicoDTO.create(entity);
	}

	public List<Medico> findAll() {
        return medicoRepository.findAll();

	}

	
	private MedicoDTO convertToMedicoDTO(Medico medico) {
		return MedicoDTO.create(medico);
	}


	
}
