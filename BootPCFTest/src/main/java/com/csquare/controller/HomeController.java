package com.csquare.controller;

import java.util.Base64;
import java.util.List;

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
public class HomeController {

	ModelAndView mv = new ModelAndView("SPA");
	HttpSession session=null;

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
			@RequestParam("password") String password, HttpServletRequest request) {
		User user = new User(username, password);
		User userOutput = IDAO.validateUser(user);
		String loginStatus = userOutput.getLoginStatus();
		if (loginStatus.equals(Constants.login_success)) {
			mv.addObject("viewName", "home.ftl");
			session = request.getSession(true);
			session.setAttribute("sessionId", Base64.getEncoder().encode(userOutput.getEmail().getBytes()));
			mv.addObject("user", userOutput);
		} else if (loginStatus.equals(Constants.login_failure)) {
			request.setAttribute("msg", "Please Enter Correct Password");
			mv.addObject("viewName", "login.ftl");
		} else if (loginStatus.equals(Constants.login_email_not_exists)) {
			request.setAttribute("msg", "Email doesn't exist in our records.");
			mv.addObject("viewName", "login.ftl");
		}
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
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		mv.clear();
		if(session != null) {
			session.invalidate();
		}
		mv.setViewName("SPA");
		mv.addObject("viewName", "home.ftl");
		request.setAttribute("msg", "You've logged out successfully. Thank you for your time.");
		return mv;
	}
	
	@RequestMapping("/TechDiff")
	public ModelAndView techDiff() {
		mv.addObject("viewName", "techdiff.ftl");
		return mv;
	}
	
}
