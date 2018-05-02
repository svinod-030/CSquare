package com.csquare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("SPA");
		HttpSession session=request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		mv.addObject("viewName", "home.ftl");
		request.setAttribute("msg", "You've logged out successfully. Thank you for your time.");
		return mv;
	}
}
