package com.kjh.protot.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	@RequestMapping("/usr/main/test")
	@ResponseBody
	public String test() {
		System.out.println("test");
		return "서버 확인";
	}

}
