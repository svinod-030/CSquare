package com.csquare.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyErrorController implements ErrorController {

	ModelAndView mv = new ModelAndView("SPA");
	private static final String errorPath = "/error";
	
	@RequestMapping(value = errorPath)
	public ModelAndView error() {
		mv.addObject("viewName", "techdiff.ftl");
		return mv;
	}

	@Override
	public String getErrorPath() {
		return errorPath;
	}
}
