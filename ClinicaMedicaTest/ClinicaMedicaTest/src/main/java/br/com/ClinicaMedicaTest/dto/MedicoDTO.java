package br.com.ClinicaMedicaTest.dto;

import br.com.ClinicaMedicaTest.model.Medico;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MedicoDTO {
	private Long id;
	private String nomeMedico;
	private String crm;
	private int idade;
	
	public MedicoDTO(Medico medico) {
		this.id = medico.getId();
		this.nomeMedico = medico.getNomeMedico();
		this.crm = medico.getCrm();
		this.idade = medico.getIdade();
	}
	
	
}