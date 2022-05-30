package br.com.ClinicaMedicaTest.form;

import java.time.LocalDateTime;
import java.util.List;

import br.com.ClinicaMedicaTest.model.Consultorio;
import br.com.ClinicaMedicaTest.model.Medico;
import br.com.ClinicaMedicaTest.repository.ConsultorioRepository;
import br.com.ClinicaMedicaTest.repository.MedicoRepository;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ConsultorioFORM {
	private long id;
	private String especialidadeMedica;
	private String numeroConsultorio;
	private LocalDateTime dataHoraConsulta = LocalDateTime.now();
	private String nomePaciente;
	private String nomeMedico;
	
	public Consultorio converter( MedicoRepository medicoRepository) {
		List<Medico> medico = medicoRepository.findByNomeMedico(nomeMedico);
		return new Consultorio( especialidadeMedica,numeroConsultorio,dataHoraConsulta,nomePaciente,medico);
	}
	
	/*●	Nome do Paciente
●	Especialidade Médica
●	Nome do Médico
●	CRM do Médico
●	Data/Hora
●	Nº Consultório*/
}
