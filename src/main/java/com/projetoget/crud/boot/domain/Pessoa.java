package com.projetoget.crud.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "PESSOAS")
public class Pessoa extends AbstractEntity<Long> {

	@NotBlank(message = "O nome da pessoa é obrigatório.")
	@Size(max = 60, message = "O nome da pessoa deve conter no máximo 60 caracteres.")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@NotNull(message = "Selecione a turma relativa a pessoa.")
	@ManyToOne
	@JoinColumn(name = "id_turma_fk")
	private Turma turma;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Evento> eventos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	} 	
}