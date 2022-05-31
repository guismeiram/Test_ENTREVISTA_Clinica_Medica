package br.com.ClinicaMedicaTest.model;

import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "TB_CONSULTORIO")
public class Consultorio {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String numeroConsultorio;
	private LocalDateTime dataHoraConsulta;
	private String especialidadeMedica;
	@ManyToOne
	private Consulta consulta;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumeroConsultorio() {
		return numeroConsultorio;
	}
	public void setNumeroConsultorio(String numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}
	public LocalDateTime getDataHoraConsulta() {
		return dataHoraConsulta;
	}
	public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
		this.dataHoraConsulta = dataHoraConsulta;
	}
	public String getEspecialidadeMedica() {
		return especialidadeMedica;
	}
	public void setEspecialidadeMedica(String especialidadeMedica) {
		this.especialidadeMedica = especialidadeMedica;
	}
	
	
}
	




	
