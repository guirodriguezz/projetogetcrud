package com.projetoget.crud.boot.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "EVENTOS")
public class Evento extends AbstractEntity<Long> {

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false, unique = true)
	private String nome;

	@NotNull
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal valorDaEntrada;

	@NotNull
	@PastOrPresent(message = "{PastOrPresent.evento.dataEntrada}")
	@DateTimeFormat(iso = ISO.DATE, pattern = "")
	@Column(name = "data_entrada", nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrada;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_saida", columnDefinition = "DATE")
	private LocalDate dataSaida;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;

	@OneToMany(mappedBy = "evento")
	private List<Pessoa> pessoas;

//	@NotNull(message = "{NotNull.evento.pessoa}")
//	@ManyToOne
//	@JoinColumn(name = "pessoa_id_fk")
//	private Pessoa pessoa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorDaEntrada() {
		return valorDaEntrada;
	}

	public void setValorDaEntrada(BigDecimal valorDaEntrada) {
		this.valorDaEntrada = valorDaEntrada;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

//	public Pessoa getPessoa() {
//		return pessoa;
//	}
//
//	public void setPessoa(Pessoa pessoa) {
//		this.pessoa = pessoa;
//	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
