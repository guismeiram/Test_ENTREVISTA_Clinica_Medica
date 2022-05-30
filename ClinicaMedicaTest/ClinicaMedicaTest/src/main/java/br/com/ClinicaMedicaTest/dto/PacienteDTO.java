package br.com.ClinicaMedicaTest.dto;

import java.time.LocalDateTime;

import br.com.ClinicaMedicaTest.model.Paciente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PacienteDTO {
	 private Long id;
	 private LocalDateTime dataHoraConsulta = LocalDateTime.now();
	 private String nomePaciente;
	 
	 
	public PacienteDTO(Paciente paciente) {
		this.id = paciente.getId();
		this.dataHoraConsulta = paciente.getDataHoraConsulta();
		this.nomePaciente = paciente.getNomePaciente();
	}
	 
	 
}
