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

//	List<Evento> findByPessoaId(Long id);

	List<Evento> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);

	List<Evento> findByDataEntrada(LocalDate entrada);

	List<Evento> findByDataSaida(LocalDate saida);
}
