package com.kjh.protot.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping("/usr/home/test")
	@ResponseBody
	public String test() {

		return "서버 확인";
	}
	
	@RequestMapping("/usr/home/main")
	public String showMain() {
		return "usr/home/main";
	}
	
	
	
}