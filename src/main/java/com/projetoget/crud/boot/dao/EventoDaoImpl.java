package com.projetoget.crud.boot.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.projetoget.crud.boot.domain.Evento;

@Repository
public class EventoDaoImpl extends AbstractDao<Evento, Long> implements EventoDao {

	public List<Evento> findByNome(String nome) {

		return createQuery("select e from Evento e where e.nome like concat('%',?1,'%') ", nome);
	}
	
	//Método para realziar busca por data do evento, no banco.

	@Override
	public List<Evento> findByDataEvento(LocalDate dEvento) {
		String jpql = new StringBuilder("select e from Evento e ").append("where e.dataEvento = ?1 ")
				.append("order by e.dataEvento asc").toString();
		return createQuery(jpql, dEvento);
	}
	
	//Método para realziar busca por data do evento, no banco (Não utilizado).

	@Override
	public List<Evento> findByHoraEvento(LocalDate hEvento) {
		String jpql = new StringBuilder("select e from Evento e ").append("where e.horaEvento = ?1 ")
				.append("order by e.horaEvento asc").toString();
		return createQuery(jpql, hEvento);
	}

}
