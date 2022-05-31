package br.com.ClinicaMedicaTest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@NoArgsConstructor
@Entity
@Table(name = "TB_PACIENTE")
public class Paciente extends Pessoa{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
