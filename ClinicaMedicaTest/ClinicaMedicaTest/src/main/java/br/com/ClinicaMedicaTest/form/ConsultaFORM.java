package br.com.ClinicaMedicaTest.form;

import java.time.LocalDateTime;
import java.util.List;

import br.com.ClinicaMedicaTest.model.Consulta;
import br.com.ClinicaMedicaTest.model.Consultorio;
import br.com.ClinicaMedicaTest.model.Pessoa;
import br.com.ClinicaMedicaTest.repository.ConsultorioRepository;
import br.com.ClinicaMedicaTest.repository.PessoaRepository;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ConsultaFORM {
	private long id;
	private String especialidadeMedica;
	private String numeroConsultorio;
	private LocalDateTime dataHoraConsulta = LocalDateTime.now();
	private String nome;
	private String crm;
	
	public Consulta converter(PessoaRepository pessoaRepository, ConsultorioRepository consultorioRepository) {
		List<Pessoa> pessoa = pessoaRepository.findByNome(nome);
		List<Consultorio> consultorio = consultorioRepository.findByEspecialidadeMedica(especialidadeMedica);

		return new Consulta(pessoa, consultorio);
	}
	
	
	/*●	Nome do Paciente
●	Especialidade Médica
●	Nome do Médico
●	CRM do Médico
●	Data/Hora
●	Nº Consultório*/
}
