package com.csquare.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csquare.dao.IDAO;
import com.csquare.teo.User;

@Controller
public class HomeController {

	ModelAndView mv = new ModelAndView("SPA");

	@RequestMapping("/")
	public ModelAndView displayIndexPage() {
		mv.addObject("viewName", "home.ftl");
		return mv;
	}

	@RequestMapping("/page1")
	public ModelAndView displaySomePage() {
		mv.addObject("viewName", "page1.ftl");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView displayLoginPage() {
		mv.addObject("viewName", "login.ftl");
		return mv;
	}

	@RequestMapping("/signUp")
	public ModelAndView displaySignUpPage() {
		mv.addObject("viewName", "login.ftl");
		return mv;
	}

	@RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
	public ModelAndView submitLoginForm(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		mv.addObject("viewName", "home.ftl");
		User user = new User(username, password);
		String output = IDAO.validateUser(user);
		mv.addObject("msg", output);
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

	@RequestMapping("/getAllUsers")
	public ModelAndView getAllUsers(@RequestParam("key") String key) {
		mv.addObject("viewName", "users.ftl");
		List<User> users = IDAO.getAllUsers();
		mv.addObject("users", users);
		return mv;
	}

	@RequestMapping("/dropUsersTable")
	public ModelAndView dropUsers(@RequestParam("key") String key) {
		mv.addObject("viewName", "home.ftl");
		String output = "::Invalid entry::";
		if (key.equals("39323")) {
			output = IDAO.dropUsersTable();
		}
		mv.addObject("msg", output);
		return mv;
	}

	@RequestMapping("/addUsersTable")
	public ModelAndView addUsers(@RequestParam("key") String key) {
		mv.addObject("viewName", "home.ftl");
		String output = "::Invalid entry::";
		if (key.equals("39323")) {
			output = IDAO.addUsersTable();
		}
		mv.addObject("msg", output);
		return mv;
	}

}
