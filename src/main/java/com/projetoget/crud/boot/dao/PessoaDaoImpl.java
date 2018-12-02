package com.projetoget.crud.boot.dao;

import org.springframework.stereotype.Repository;

import com.projetoget.crud.boot.domain.Pessoa;

@Repository
public class PessoaDaoImpl extends AbstractDao<Pessoa, Long> implements PessoaDao {

}
