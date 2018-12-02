package com.projetoget.crud.boot.web.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.projetoget.crud.boot.domain.Evento;

public class EventoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Evento.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Evento e = (Evento) object;
		
		LocalDate entrada = e.getDataEntrada();
		
		if (e.getDataSaida() != null) {
			if (e.getDataSaida().isBefore(entrada)) {
				errors.rejectValue("dataSaida", "PosteriorDataEntrada.evento.dataSaida");
			}
		}
	}

}
