package com.csquare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csquare.dao.IDAO;
import com.csquare.teo.User;

@Controller
public class SignUpController {

	ModelAndView mv = new ModelAndView("SPA");
	

	@RequestMapping("/signUp")
	public ModelAndView displaySignUpPage() {
		mv.addObject("viewName", "login.ftl");
		return mv;
	}
	
	@RequestMapping(value = "/submitSignUp", method = RequestMethod.POST)
	public ModelAndView signUpUser(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
		mv.addObject("viewName", "home.ftl");
		User user = new User("", email, password, firstname, lastname);
		String msg = IDAO.addUser(user);
		mv.addObject("msg", msg);
		return mv;
	}
}
