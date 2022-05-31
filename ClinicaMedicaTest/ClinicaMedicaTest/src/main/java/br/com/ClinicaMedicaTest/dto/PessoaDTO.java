package br.com.ClinicaMedicaTest.dto;

import br.com.ClinicaMedicaTest.model.Pessoa;

public class PessoaDTO {
	  private Long id;
	  private String nome;
	  private int idade;
	  
	  
	  
	public PessoaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.idade = pessoa.getIdade();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	  
	  

}
