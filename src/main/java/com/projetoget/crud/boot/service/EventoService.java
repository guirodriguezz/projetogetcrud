package com.projetoget.crud.boot.service;

import java.time.LocalDate;
import java.util.List;

import com.projetoget.crud.boot.domain.Evento;

public interface EventoService {

	void salvar(Evento evento);

	void editar(Evento evento);

	void excluir(Long id);

	Evento buscarPorId(Long id);

	List<Evento> buscarTodos();

	List<Evento> buscarPorNome(String nome);

	List<Evento> buscarPorData(LocalDate dEvento);

	boolean eventoTemPessoas(Long id);
}
