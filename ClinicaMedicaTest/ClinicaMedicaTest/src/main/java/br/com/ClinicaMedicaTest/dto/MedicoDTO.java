package br.com.ClinicaMedicaTest.dto;

import java.io.Serializable;


import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.ClinicaMedicaTest.model.Consulta;
import br.com.ClinicaMedicaTest.model.Medico;
import lombok.AllArgsConstructor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@JsonPropertyOrder({"id","crm","nome","idade"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MedicoDTO  implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;
	@JsonProperty("crm")
	private String crm;
	@JsonProperty("especialidade")
	private String especialidade;
	@JsonProperty("nome")
	private String nome;
	@JsonProperty("idade")
	private int idade;
	
	

}
