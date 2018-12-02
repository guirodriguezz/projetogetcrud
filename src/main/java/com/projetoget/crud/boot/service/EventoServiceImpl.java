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

	@Override
	public List<Evento> buscarPorPessoa(Long id) {
		
		return dao.findByPessoaId(id);
	}

	@Override
    public List<Evento> buscarPorDatas(LocalDate entrada, LocalDate saida) {
	    if (entrada != null && saida != null) {	    	
            return dao.findByDataEntradaDataSaida(entrada, saida);
        } else if (entrada != null) {        	
	        return dao.findByDataEntrada(entrada);
        } else if (saida != null) {        	
	        return dao.findByDataSaida(saida);
        } else {
        	return new ArrayList<>();
        }
    }
}
