package com.projetoget.crud.boot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetoget.crud.boot.domain.Turma;
import com.projetoget.crud.boot.service.TurmaService;

@Controller
@RequestMapping("/turmas")
public class TurmaController {
	
	@Autowired
	private TurmaService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Turma turma) {
		return "turma/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("turmas", service.buscarTodos());
		return "turma/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Turma turma, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "turma/cadastro";
		}
		
		service.salvar(turma);
		attr.addFlashAttribute("success", "Turma inserida com sucesso.");
		return "redirect:/turmas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("turma", service.buscarPorId(id));
		return "turma/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Turma turma, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "turma/cadastro";
		}
		
		service.editar(turma);
		attr.addFlashAttribute("success", "Turma editada com sucesso.");
		return "redirect:/turmas/cadastrar";
	}
	
	// Método que utiliza objeto da service, para excluir turma sem pessoas.
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		if (service.turmaTemPessoas(id)) {
			model.addAttribute("fail", "Turma não removida. Possui pessoas(s) vinculada(s).");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Turma excluída com sucesso.");
		}
		
		return listar(model);
	}
	
	
}
