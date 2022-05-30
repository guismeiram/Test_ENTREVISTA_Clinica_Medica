package br.com.ClinicaMedicaTest.form;

import java.time.LocalDateTime;

import br.com.ClinicaMedicaTest.model.Consultorio;
import br.com.ClinicaMedicaTest.repository.ConsultorioRepository;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ConsultorioFORM {
	private String especialidadeMedica;
	private String numeroConsultorio;
	
	public Consultorio converter(ConsultorioRepository consultorioRepository) {
		Consultorio consultorio = consultorioRepository.findByEspecialidadeMedica(especialidadeMedica);
		return new Consultorio(especialidadeMedica, numeroConsultorio);
	}
}
