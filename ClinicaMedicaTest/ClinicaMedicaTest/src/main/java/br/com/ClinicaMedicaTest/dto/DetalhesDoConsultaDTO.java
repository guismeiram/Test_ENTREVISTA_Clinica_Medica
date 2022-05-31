package br.com.ClinicaMedicaTest.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class DetalhesDoConsultaDTO {
	private Long id;
	private String nomeMedico;
	private String crm;
	private LocalDateTime dataHoraConsulta = LocalDateTime.now();
	private String nomePaciente;
	private String especialidadeMedica;
	private String numeroConsultorio;
	
	
	/*public DetalhesDoConsultaDTO(Consultorio consultorio) {
		this.id = consultorio.getId();
		this.nomeMedico = consultorio.getMedico().getNomeMedico().;
		this.crm = consultorio.getMedico();
		this.dataHoraConsulta = consultorio.getPaciente().getDataHoraConsulta();
		this.nomePaciente = consultorio.getPaciente().getNomePaciente();
		this.especialidadeMedica = consultorio.getEspecialidadeMedica();
		this.numeroConsultorio = consultorio.getNumeroConsultorio();
		this.paciente = new ArrayList<>();
		this.paciente.addAll(consultorio.getPaciente().stream().map(PacienteDTO::new).collect(Collectors.toList()));
		this.medico = new ArrayList<>();
		this.medico.addAll(consultorio.getMedico().stream().map(MedicoDTO::new).collect(Collectors.toList()));
		
		
	}*/
	
	
	
	/*●	Nome do Paciente
●	Especialidade Médica
●	Nome do Médico
●	CRM do Médico
●	Data/Hora
●	Nº Consultório
*/
	
}
