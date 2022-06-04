package br.com.ClinicaMedicaTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ClinicaMedicaTest.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Long>{

}
