package com.projetoget.crud.boot.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "TURMAS")
public class Turma extends AbstractEntity<Long> {
	
	// Nome da turma tem validação própria que se encontra em ValidationMessages.

	@NotBlank(message = "Informe uma turma.")
	@Size(min = 3, max = 60, message = "O nome da turma deve ter entre {min} e {max} caracteres.")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	// Mapeamento entre turma e pessoas.
	
	@OneToMany(mappedBy = "turma")
	private List<Pessoa> pessoas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
}
