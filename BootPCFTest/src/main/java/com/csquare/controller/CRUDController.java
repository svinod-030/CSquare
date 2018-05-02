package com.csquare.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csquare.dao.IDAO;
import com.csquare.teo.User;

@Controller
public class CRUDController {

	ModelAndView mv = new ModelAndView("SPA");
	
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
