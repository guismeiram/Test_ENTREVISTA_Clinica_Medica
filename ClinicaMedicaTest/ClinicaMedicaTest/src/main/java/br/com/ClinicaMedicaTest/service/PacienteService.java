package br.com.ClinicaMedicaTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ClinicaMedicaTest.model.Medico;
import br.com.ClinicaMedicaTest.model.Paciente;
import br.com.ClinicaMedicaTest.repository.MedicoRepository;
import br.com.ClinicaMedicaTest.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private final PacienteRepository pacienteRepository;

	
	@Autowired
	public PacienteService(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}

	public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
	
	public List<Paciente> findAll() {
        return pacienteRepository.findAll();

	}
	
	public Paciente getById(Long id) {
		return pacienteRepository.getById(id);
		
	}
}
