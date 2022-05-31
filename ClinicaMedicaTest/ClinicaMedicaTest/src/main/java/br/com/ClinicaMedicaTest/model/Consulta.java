package br.com.ClinicaMedicaTest.model;

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
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "TB_CONSULTA")
public class Consulta {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@OneToMany(mappedBy = "consulta")
	private List<Consultorio> consultorio;
	@OneToMany(mappedBy = "consulta")
	private List<Pessoa> pessoa;
	
	public Consulta(List<Pessoa> pessoa, List<Consultorio> consultorio) {
		this.pessoa = pessoa;
		this.consultorio = consultorio;
	}
	
}
