package br.estacio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormularioController {
	
	@RequestMapping("/edit")
	public String home() {
	return "formulario";
	}	


}