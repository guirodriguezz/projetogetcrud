package com.projetoget.crud.boot.dao;

import java.time.LocalDate;
import java.util.List;

import com.projetoget.crud.boot.domain.Evento;

public interface EventoDao {

	void save(Evento evento);

	void update(Evento evento);

	void delete(Long id);

	Evento findById(Long id);

	List<Evento> findAll();

	List<Evento> findByNome(String nome);

	List<Evento> findByDataEvento(LocalDate dEvento);

	List<Evento> findByHoraEvento(LocalDate hEvento);
}
