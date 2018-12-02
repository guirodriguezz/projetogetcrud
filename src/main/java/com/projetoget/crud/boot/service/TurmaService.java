package com.projetoget.crud.boot.service;

import java.util.List;

import com.projetoget.crud.boot.domain.Turma;

public interface TurmaService {

    void salvar(Turma turma);

    void editar(Turma turma);

    void excluir(Long id);

    Turma buscarPorId(Long id);
    
    List<Turma> buscarTodos();

	boolean turmaTemPessoas(Long id);
}
