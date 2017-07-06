package com.xiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiao.entity.User;
import com.xiao.service.IUserService;

@Controller
@RequestMapping("/user")
public class HelloController {

	@RequestMapping("hello")
	public @ResponseBody String hello() {
		return "hello, world";
	}
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/getUser")
	public @ResponseBody String getUser(){
		User user = userService.listUsers("111");
		return user.getName();
	}
	
}