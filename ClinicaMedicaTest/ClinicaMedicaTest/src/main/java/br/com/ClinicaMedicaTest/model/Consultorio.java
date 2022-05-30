package br.com.ClinicaMedicaTest.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@EqualsAndHashCode
@Entity
@Table(name = "TB_CONSULTORIO")
public class Consultorio {

	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String especialidadeMedica;
	private String numeroConsultorio;
	private LocalDateTime dataHoraConsulta = LocalDateTime.now();
	private String nomePaciente;
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Medico> medico;
	
	
	public Consultorio(String especialidadeMedica, String numeroConsultorio, LocalDateTime dataHoraConsulta,
			String nomePaciente, List<Medico> medico) {
		this.especialidadeMedica = especialidadeMedica;
		this.numeroConsultorio = numeroConsultorio;
		this.dataHoraConsulta = dataHoraConsulta;
		this.nomePaciente = nomePaciente;
		this.medico = medico;
	}


	
	
	

		




}
	




	
