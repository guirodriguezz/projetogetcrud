package com.projetoget.crud.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetoget.crud.boot.dao.TurmaDao;
import com.projetoget.crud.boot.domain.Turma;

@Service
public class TurmaServiceImpl implements TurmaService {
	
	@Autowired
	private TurmaDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Turma turma) {
		dao.save(turma);		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Turma turma) {
		dao.update(turma);		
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Turma buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Turma> buscarTodos() {
		
		return dao.findAll();
	}
	
	// Método para ligar, através do ID, turma com pessoas. 

	@Override
	public boolean turmaTemPessoas(Long id) {
		if (buscarPorId(id).getPessoas().isEmpty()) {
			return false;
		}
		return true;
	}

}
