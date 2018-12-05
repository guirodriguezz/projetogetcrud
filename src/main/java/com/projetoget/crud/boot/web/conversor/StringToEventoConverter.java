package com.projetoget.crud.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.projetoget.crud.boot.domain.Evento;
import com.projetoget.crud.boot.service.EventoService;

@Component
public class StringToEventoConverter implements Converter<String, Evento> {
	
	@Autowired
	private EventoService service;

	@Override
	public Evento convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}