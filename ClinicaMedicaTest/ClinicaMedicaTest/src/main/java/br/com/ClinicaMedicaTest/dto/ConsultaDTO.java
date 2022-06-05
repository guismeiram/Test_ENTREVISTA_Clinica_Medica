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

@JsonPropertyOrder({"id","nome","quantidade","valor", "pessoaId", "consultorioId"})

public class ConsultaDTO extends RepresentationModel<ConsultaDTO> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private long id;
	@JsonProperty("pessoa")
	private List<Medico> medico = new ArrayList<Medico>();
	@JsonProperty("consultorio")
    private List<Consultorio> consultorio = new ArrayList<Consultorio>();
	
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public List<Medico> getMedico() {
		return medico;
	}


	public void setMedico(List<Medico> medico) {
		this.medico = medico;
	}


	public List<Consultorio> getConsultorio() {
		return consultorio;
	}


	public void setConsultorio(List<Consultorio> consultorio) {
		this.consultorio = consultorio;
	}


	public ConsultaDTO(Consulta consulta) {
		this.medico = consulta.getMedico();
		this.consultorio = consulta.getConsultorio();
	}


	public ConsultaDTO() {
	}
	
	
	
}
