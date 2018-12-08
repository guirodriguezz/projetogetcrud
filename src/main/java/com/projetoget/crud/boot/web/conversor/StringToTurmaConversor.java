package com.projetoget.crud.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.projetoget.crud.boot.domain.Turma;
import com.projetoget.crud.boot.service.TurmaService;

@Component
public class StringToTurmaConversor implements Converter<String, Turma> {
	
	@Autowired
	private TurmaService service;

	@Override
	public Turma convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
