package br.estacio.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.estacio.model.User;

@Controller
@RequestMapping(value = "/user/*")
public class UserController {

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView showForm() {
		ModelAndView model = new ModelAndView("registerForm");
		model.addObject("user", new User());
		return model;
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView postForm(@Valid @ModelAttribute("user") User user, BindingResult result) {
		ModelAndView model = new ModelAndView();

		if (result.hasErrors()) {
			model.setViewName("registerForm");
		} else {
			System.out.println(user);
			model.addObject("msg", "OK");
			model.setViewName("home");
		}
		return model;
	}

}
