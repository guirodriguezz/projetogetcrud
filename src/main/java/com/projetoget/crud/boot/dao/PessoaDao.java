package com.projetoget.crud.boot.dao;

import java.util.List;

import com.projetoget.crud.boot.domain.Pessoa;

public interface PessoaDao {

	void save(Pessoa pessoa);

	void update(Pessoa pessoa);

	void delete(Long id);

	Pessoa findById(Long id);

	List<Pessoa> findAll();
}
