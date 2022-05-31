package br.com.ClinicaMedicaTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ClinicaMedicaTest.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long>{

	List<Pessoa> findByNome(String nome);

}
