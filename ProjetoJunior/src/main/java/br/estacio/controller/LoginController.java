package br.estacio.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.estacio.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response,
	@RequestParam(value = "error", required = false) String error,
	@RequestParam(value = "logout", required = false) String logout, Locale loc) {
	ModelAndView model = new ModelAndView();
	model.setViewName("loginForm");
	
	if (error != null) {
	model.addObject("error", "erro de login");
	} else if (logout != null) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
		new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		model.setViewName("home");
		}
		return model;
		}
	

}
