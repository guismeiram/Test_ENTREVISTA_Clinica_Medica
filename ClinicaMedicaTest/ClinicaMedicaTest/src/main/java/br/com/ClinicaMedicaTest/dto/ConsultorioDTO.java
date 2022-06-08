package br.com.ClinicaMedicaTest.dto;

import java.io.Serializable;
import java.time.LocalDateTime;


import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.ClinicaMedicaTest.model.Consulta;
import br.com.ClinicaMedicaTest.model.Consultorio;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"id","numeroConsultorio","dataHoraConsulta"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ConsultorioDTO extends RepresentationModel<ConsultorioDTO> implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private long id;
	@JsonProperty("numeroConsultorio")
	private String numero;
	@JsonProperty("dataHoraConsulta")
	private LocalDateTime data_hora;
	private Consulta consulta;
	
	public static ConsultorioDTO create(Consultorio consultorio) {
		return new ModelMapper().map(consultorio, ConsultorioDTO.class);
	}
		
		
		
}