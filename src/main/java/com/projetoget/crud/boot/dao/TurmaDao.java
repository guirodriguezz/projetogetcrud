package com.projetoget.crud.boot.dao;

import java.util.List;

import com.projetoget.crud.boot.domain.Turma;

public interface TurmaDao {

    void save(Turma turma);

    void update(Turma turma);

    void delete(Long id);

    Turma findById(Long id);

    List<Turma> findAll();
}
