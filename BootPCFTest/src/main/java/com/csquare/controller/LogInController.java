package com.csquare.controller;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csquare.dao.IDAO;
import com.csquare.teo.User;
import com.csquare.util.Constants;

@Controller
public class LogInController {

	ModelAndView mv = new ModelAndView("SPA");
	HttpSession session=null;
	
	@RequestMapping("/login")
	public ModelAndView displayLoginPage() {
		mv.addObject("viewName", "login.ftl");
		return mv;
	}
	
	@RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
	public ModelAndView submitLoginForm(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpServletRequest request) {
		User user = new User(username, password);
		User userOutput = IDAO.validateUser(user);
		String loginStatus = userOutput.getLoginStatus();
		if (loginStatus.equals(Constants.login_success)) {
			mv.addObject("viewName", "home.ftl");
			session = request.getSession(true);
			session.setAttribute("sessionId", Base64.getEncoder().encode(userOutput.getEmail().getBytes()));
			session.setAttribute("user", userOutput);
		} else if (loginStatus.equals(Constants.login_failure)) {
			request.setAttribute("msg", "Please Enter Correct Password");
			mv.addObject("viewName", "login.ftl");
		} else if (loginStatus.equals(Constants.login_email_not_exists)) {
			request.setAttribute("msg", "Email doesn't exist in our records.");
			mv.addObject("viewName", "login.ftl");
		}
		return mv;
	}
}
