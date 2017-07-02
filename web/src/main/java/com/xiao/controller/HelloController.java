package com.xiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class HelloController {

	@RequestMapping("hello")
	public @ResponseBody String hello() {
		return "hello, world";
	}
}