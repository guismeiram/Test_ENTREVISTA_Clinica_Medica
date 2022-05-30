package br.com.ClinicaMedicaTest.form;


import br.com.ClinicaMedicaTest.model.Consultorio;
import br.com.ClinicaMedicaTest.repository.ConsultorioRepository;


public class AtualizacaoConsultorioFORM {
	private String especialidadeMedica;
	private String numeroConsultorio;
	
	public void setEspecialidademedica(String especialidadeMedica,String numeroConsultorio ) {
		this.especialidadeMedica = especialidadeMedica;
		this.numeroConsultorio = numeroConsultorio;
	}
	
	public Consultorio atualizar(Long id, ConsultorioRepository consultorioRepository) {
		Consultorio consultorio = consultorioRepository.getOne(id);
		
		consultorio.setEspecialidadeMedica(this.especialidadeMedica);
		consultorio.setNumeroConsultorio(this.numeroConsultorio);
		return consultorio;
		
	}

	public String getEspecialidadeMedica() {
		return especialidadeMedica;
	}

	public void setEspecialidadeMedica(String especialidadeMedica) {
		this.especialidadeMedica = especialidadeMedica;
	}

	public String getNumeroConsultorio() {
		return numeroConsultorio;
	}

	public void setNumeroConsultorio(String numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}
	
}
