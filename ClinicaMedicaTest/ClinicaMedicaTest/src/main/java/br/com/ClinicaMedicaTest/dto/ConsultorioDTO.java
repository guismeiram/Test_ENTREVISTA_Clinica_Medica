package br.com.ClinicaMedicaTest.dto;

import java.time.LocalDateTime;

public class ConsultorioDTO {
	 private long id;
		private String numeroConsultorio;
		private LocalDateTime dataHoraConsulta;
		private String especialidadeMedica;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNumeroConsultorio() {
			return numeroConsultorio;
		}
		public void setNumeroConsultorio(String numeroConsultorio) {
			this.numeroConsultorio = numeroConsultorio;
		}
		public LocalDateTime getDataHoraConsulta() {
			return dataHoraConsulta;
		}
		public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
			this.dataHoraConsulta = dataHoraConsulta;
		}
		public String getEspecialidadeMedica() {
			return especialidadeMedica;
		}
		public void setEspecialidadeMedica(String especialidadeMedica) {
			this.especialidadeMedica = especialidadeMedica;
		}
		
		
		
}
