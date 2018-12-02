package com.projetoget.crud.boot.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetoget.crud.boot.domain.Evento;
import com.projetoget.crud.boot.domain.Pessoa;
import com.projetoget.crud.boot.domain.UF;
import com.projetoget.crud.boot.service.EventoService;
import com.projetoget.crud.boot.service.PessoaService;
import com.projetoget.crud.boot.web.validator.EventoValidator;

@Controller
@RequestMapping("/eventos")
public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	@Autowired
	private PessoaService pessoaService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new EventoValidator());
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(Evento evento) {
		return "evento/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("eventos", eventoService.buscarTodos());
		return "evento/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Evento evento, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "evento/cadastro";
		}
		
		eventoService.salvar(evento);
		attr.addFlashAttribute("success", "Evento inserido com sucesso.");
		return "redirect:/eventos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("evento", eventoService.buscarPorId(id));
		return "evento/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Evento evento, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "evento/cadastro";
		}
		
		eventoService.editar(evento);
		attr.addFlashAttribute("success", "Evento editado com sucesso.");
		return "redirect:/eventos/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		eventoService.excluir(id);
		attr.addFlashAttribute("success", "Evento removido com sucesso.");
		return "redirect:/eventos/listar";
	}	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("eventos", eventoService.buscarPorNome(nome));
		return "evento/lista";
	}
	
	@GetMapping("/buscar/pessoa")
	public String getPorPessoa(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("eventos", eventoService.buscarPorId(id));
		return "evento/lista";
	}		
	
    @GetMapping("/buscar/data")
    public String getPorDatas(@RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
                              @RequestParam("saida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
                              ModelMap model) {

        model.addAttribute("eventos", eventoService.buscarPorDatas(entrada, saida));
        return "evento/lista";
    }
	
	@ModelAttribute("pessoas")
	public List<Pessoa> getPessoas() {
		return pessoaService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
}
