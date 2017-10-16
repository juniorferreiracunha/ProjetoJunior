package br.estacio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home/*")
public class HomeController {

	@RequestMapping(value = "")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "edit")
	public String edit(ModelMap model) {
		model.addAttribute("msg", "Ola!");
		return "edit";
	}

	@RequestMapping(value = "edit/{id}")
	public String editId(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("msg", id);
		return "edit";
	}

}
