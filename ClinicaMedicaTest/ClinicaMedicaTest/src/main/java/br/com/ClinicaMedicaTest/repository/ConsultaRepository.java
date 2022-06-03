package br.com.ClinicaMedicaTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ClinicaMedicaTest.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
	Consulta findById(long id);


}
