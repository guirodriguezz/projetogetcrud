package com.projetoget.crud.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.projetoget.crud.boot.domain.Pessoa;
import com.projetoget.crud.boot.service.PessoaService;

@Component
public class StringToPessoaConversor implements Converter<String, Pessoa> {
	
	@Autowired
	private PessoaService service;

	@Override
	public Pessoa convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
