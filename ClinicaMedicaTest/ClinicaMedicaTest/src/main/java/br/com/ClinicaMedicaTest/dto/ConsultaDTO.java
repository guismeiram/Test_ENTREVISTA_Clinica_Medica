package br.com.ClinicaMedicaTest.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import br.com.ClinicaMedicaTest.model.Consulta;
import br.com.ClinicaMedicaTest.model.Consultorio;
import br.com.ClinicaMedicaTest.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ConsultaDTO {
	private long id;
	private List<Pessoa> pessoa;
	private List<Consultorio> consultorio;
	private String nome;
	private String crm;
	private LocalDateTime dataHoraConsulta = LocalDateTime.now();
	private String especialidadeMedica;
	private String numeroConsultorio;
	
	public ConsultaDTO(Consulta consulta) {
		this.id = consulta.getId();
		this.consultorio = new ArrayList<Consultorio>();
		this.pessoa  = new ArrayList<Pessoa>(); 
		

	}
	
	public static Page<ConsultaDTO> converter(Page<Consulta> consultas){
		return consultas.map(ConsultaDTO::new);
	}



	



}
