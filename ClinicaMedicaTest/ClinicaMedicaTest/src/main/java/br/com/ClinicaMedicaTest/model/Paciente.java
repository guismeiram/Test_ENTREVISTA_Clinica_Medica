package br.com.ClinicaMedicaTest.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "TB_PACIENTE")
public class Paciente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private LocalDateTime dataHoraConsulta = LocalDateTime.now();
	private String nomePaciente;
	@ManyToOne
	private Consultorio consultorio;
}

