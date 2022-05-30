package br.com.ClinicaMedicaTest.dto;

import org.springframework.data.domain.Page;

import br.com.ClinicaMedicaTest.model.Consultorio;
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
public class ConsultorioDTO {
	private long id;
	private String especialidadeMedica;
	private String numeroConsultorio;
	
	
	public ConsultorioDTO(Consultorio consultorio) {
		this.id = consultorio.getId();
		this.especialidadeMedica = consultorio.getEspecialidadeMedica();
		this.numeroConsultorio = consultorio.getNumeroConsultorio();
	}
	
	public static Page<ConsultorioDTO> converter(Page<Consultorio> consultorios){
		return consultorios.map(ConsultorioDTO::new);
	}
}
