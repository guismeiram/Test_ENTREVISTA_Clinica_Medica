package br.com.ClinicaMedicaTest.form;


import java.time.LocalDateTime;

import br.com.ClinicaMedicaTest.model.Consulta;
import br.com.ClinicaMedicaTest.repository.ConsultaRepository;
import br.com.ClinicaMedicaTest.repository.PessoaRepository;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AtualizacaoConsultaFORM {
	private long id;
	private String especialidadeMedica;
	private String numeroConsultorio;
	private LocalDateTime dataHoraConsulta = LocalDateTime.now();
	private String nome;
	private String crm;
	
	public Consulta atualizar(Long id, ConsultaRepository consultaRepository) {
		Consulta consulta = consultaRepository.getOne(id);
		
		return consulta;
		
	}

	
	
}
