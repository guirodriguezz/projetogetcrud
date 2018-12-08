package com.projetoget.crud.boot.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoget.crud.boot.dao.EventoDao;
import com.projetoget.crud.boot.domain.Evento;

@Service
@Transactional(readOnly = true)
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Evento evento) {
		dao.save(evento);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Evento evento) {
		dao.update(evento);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Evento buscarPorId(Long id) {

		return dao.findById(id);
	}

	@Override
	public List<Evento> buscarTodos() {

		return dao.findAll();
	}

	@Override
	public List<Evento> buscarPorNome(String nome) {

		return dao.findByNome(nome);
	}
	
	
	// Método para realizar busca por data no banco.
	
	@Override
	public List<Evento> buscarPorData(LocalDate dEvento) {
		if (dEvento != null) {
			return dao.findByDataEvento(dEvento);
		} else {
			return new ArrayList<>();
		}
	}
	
	// Método para, através do ID, ligar evento a pessoas no banco.

	@Override
	public boolean eventoTemPessoas(Long id) {
		if (buscarPorId(id).getPessoas().isEmpty()) {
			return false;
		}
		return true;
	}
}
