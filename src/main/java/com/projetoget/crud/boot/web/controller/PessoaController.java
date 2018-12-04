package com.projetoget.crud.boot.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetoget.crud.boot.domain.Evento;
import com.projetoget.crud.boot.domain.Pessoa;
import com.projetoget.crud.boot.domain.Turma;
import com.projetoget.crud.boot.service.EventoService;
import com.projetoget.crud.boot.service.PessoaService;
import com.projetoget.crud.boot.service.TurmaService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private TurmaService turmaService;
	@Autowired
	private EventoService eventoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Pessoa pessoa) {
		return "pessoa/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoas", pessoaService.buscarTodos());
		return "pessoa/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "pessoa/cadastro";
		}
		
		pessoaService.salvar(pessoa);
		attr.addFlashAttribute("success", "Pessoa inserida com sucesso.");
		return "redirect:/pessoas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		return "pessoa/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "pessoa/cadastro";
		}	
		
		pessoaService.editar(pessoa);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/pessoas/cadastrar";
	}
	
//	@GetMapping("/excluir/{id}")
//	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
//		if (pessoaService.pessoaTemEventos(id)) {
//			attr.addFlashAttribute("fail", "Pessoa não excluida. Tem evento(s) vinculado(s).");
//		} else {
//			pessoaService.excluir(id);
//			attr.addFlashAttribute("success", "Pessoa excluida com sucesso.");
//		}
//		return "redirect:/pessoas/listar";
//	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		pessoaService.excluir(id);
		attr.addFlashAttribute("success", "Pessoa removida com sucesso.");
		return "redirect:/pessoas/listar";
	}	
	
	@ModelAttribute("turmas")
	public List<Turma> listaDeTurmas() {
		return turmaService.buscarTodos();
	}
	
	@ModelAttribute("eventos")
	public List<Evento> getEventos() {
		return eventoService.buscarTodos();
	}
}
