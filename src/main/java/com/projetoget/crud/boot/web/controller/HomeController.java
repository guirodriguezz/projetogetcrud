package com.projetoget.crud.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.projetoget.crud.boot.service.EventoService;

@Controller
public class HomeController {

	@Autowired
	private EventoService eventoService;

	@GetMapping("/")
	public String home(ModelMap model) {
		model.addAttribute("eventos", eventoService.buscarTodos());
		return "evento/lista";
	}
}
