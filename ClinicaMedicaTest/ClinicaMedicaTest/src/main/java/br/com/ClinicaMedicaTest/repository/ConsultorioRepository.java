package br.com.ClinicaMedicaTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ClinicaMedicaTest.model.Consultorio;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio,Long>{


	List<Consultorio> findByEspecialidadeMedica(String especialidadeMedica);

}
