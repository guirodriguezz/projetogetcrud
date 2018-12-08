package com.projetoget.crud.boot.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstractEntity<Long> {

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String rua;

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String bairro;

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String localEvento;
	
	// Tipo de Evento tem uma validação própria que se encontra em ValidationMessages.

	@NotNull(message = "{NotNull.endereco.tipoEvento}")
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private TiposDeEvento tipoEvento;
	
	// A validação do tamanho do campo de CEP também se encontra em ValidationMessages.

	@NotBlank
	@Size(min = 9, max = 9, message = "{Size.endereco.cep}")
	@Column(nullable = false, length = 9)
	private String cep;
	
	// Numero também tem uma validação própria que se encontra em ValidationMessages.

	@NotNull(message = "{NotNull.endereco.numero}")
	@Digits(integer = 5, fraction = 0)
	@Column(nullable = false, length = 5)
	private Integer numero;

	@Size(max = 255)
	private String complemento;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalEvento() {
		return localEvento;
	}

	public void setLocalEvento(String localEvento) {
		this.localEvento = localEvento;
	}

	public TiposDeEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TiposDeEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
