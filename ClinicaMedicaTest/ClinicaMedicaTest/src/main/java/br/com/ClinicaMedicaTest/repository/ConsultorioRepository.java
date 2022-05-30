package br.com.ClinicaMedicaTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ClinicaMedicaTest.model.Consultorio;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio,Long>{

	Consultorio findByEspecialidadeMedica(String especialidadeMedica);

}
