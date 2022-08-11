package com.kjh.protot.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AramController {

	@RequestMapping("/usr/aram/run")
	@ResponseBody
	public String run() {

		return "알람 작동";
	}

}
