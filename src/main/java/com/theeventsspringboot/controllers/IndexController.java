package com.theeventsspringboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	// METODO Q SIMULA UMA PAGINA INICIAL, OU SEJA, QUE CHAMARIA UMA PAG INICIAL
	@RequestMapping("/")
	public String index() {
		return "index page";
	}

	// PRIMEIRA REQUISICAO VIA NAVEGADOR: /VisualizaTexto
	@RequestMapping("/VisualizaTexto")
	public String visualizaTexto() {
		return "Hello Word";
	}
}
