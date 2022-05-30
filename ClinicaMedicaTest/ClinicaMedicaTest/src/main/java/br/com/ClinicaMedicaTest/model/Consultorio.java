package br.com.ClinicaMedicaTest.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "TB_CONSULTORIO")
public class Consultorio {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String especialidadeMedica;
	private String numeroConsultorio;
	@OneToMany(mappedBy = "consultorio")
	private List<Medico> medico = new ArrayList();
	@OneToMany(mappedBy = "consultorio")
	private List<Paciente> paciente = new ArrayList<>();
	

	public Consultorio(String especialidadeMedica, String numeroConsultorio) {
		this.especialidadeMedica = especialidadeMedica;
		this.numeroConsultorio = numeroConsultorio;
	}
}
