package br.com.ClinicaMedicaTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ClinicaMedicaTest.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

	List<Medico> findByNomeMedico(String nomeMedico);

}
