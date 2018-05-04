package com.csquare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csquare.dao.IDAO;
import com.csquare.teo.User;

@Controller
public class OperateUserController {

	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(@RequestParam("id") String id) {
		User output = IDAO.getUser(id);
		return output;
	}

	@RequestMapping("/deleteUser")
	@ResponseBody
	public boolean deleteUser(@RequestParam("id") String id) {
		boolean output = IDAO.deleteUser(id);
		return output;
	}

	@RequestMapping("/editUser")
	@ResponseBody
	public String editUser(@RequestParam("id") String id) {
		return "Failed to Edit";
	}
}
