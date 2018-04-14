package com.csquare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrussController {

	@RequestMapping("/makeTruss")
	public ModelAndView makeTruss() {
		ModelAndView mv=new ModelAndView("SPA");
		//ModelAndView mv=new ModelAndView("truss/makeTruss");
		mv.addObject("viewName", "truss/makeTruss.ftl");
		return mv;
	}
}