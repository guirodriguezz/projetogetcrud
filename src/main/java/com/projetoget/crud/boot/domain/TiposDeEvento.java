package com.projetoget.crud.boot.domain;

public enum TiposDeEvento {

	TC("TC", "Tecnologia"), NG("NG", "Negócios"), GA("GA", "Games"), IN("IN", "Inovação"), AP("AP", "Aplicação"),
	SI("SI", "Sistemas"), EP("EP", "Empresarial"), VA("VA", "Vários"), OT("OT", "Outros");

	private String tipo;
	private String descricao;

	TiposDeEvento(String tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDescricao() {
		return descricao;
	}
}
