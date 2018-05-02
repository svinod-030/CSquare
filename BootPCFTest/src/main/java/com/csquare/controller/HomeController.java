package com.csquare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
