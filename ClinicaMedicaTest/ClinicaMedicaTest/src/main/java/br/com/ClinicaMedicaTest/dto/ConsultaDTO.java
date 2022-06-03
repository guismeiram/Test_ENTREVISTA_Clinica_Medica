package br.com.ClinicaMedicaTest.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.ClinicaMedicaTest.model.Consulta;
import br.com.ClinicaMedicaTest.model.Consultorio;
import br.com.ClinicaMedicaTest.model.Medico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({"id","nome","quantidade","valor"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaDTO extends RepresentationModel<ConsultaDTO> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private long id;
	@JsonProperty("pessoa")
	private List<Medico> pessoa = new ArrayList<Medico>();
	@JsonProperty("consultorio")
    private List<Consultorio> consultorio = new ArrayList<Consultorio>();
	@JsonProperty("especialidadeMedica")
	private String especialidadeMedica;
	
	public static ConsultaDTO create(Consulta consulta) {
		return new ModelMapper().map(consulta, ConsultaDTO.class);
	}
}
