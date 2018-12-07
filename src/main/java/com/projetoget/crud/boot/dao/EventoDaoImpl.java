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

//	@Override
//	public List<Evento> findByPessoaId(Long id) {
//		
//		return createQuery("select e from Funcionario e where e.cargo.id = ?1", id);
//	}

//	@Override
//	public List<Evento> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
//		String jpql = new StringBuilder("select e from Evento e ")
//				.append("where e.dataEntrada >= ?1 and e.dataSaida <= ?2 ")
//				.append("order by e.dataEntrada asc")
//				.toString();
//		return createQuery(jpql, entrada, saida);
//	}

	@Override
	public List<Evento> findByDataEvento(LocalDate dEvento) {
		String jpql = new StringBuilder("select e from Evento e ")
				.append("where e.dataEvento = ?1 ")
				.append("order by e.dataEvento asc")
				.toString();
		return createQuery(jpql, dEvento);
	}

	@Override
	public List<Evento> findByHoraEvento(LocalDate hEvento) {
		String jpql = new StringBuilder("select e from Evento e ")
				.append("where e.horaEvento = ?1 ")
				.append("order by e.horaEvento asc")
				.toString();
		return createQuery(jpql, hEvento);
	}	
	
}
