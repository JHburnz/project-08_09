package com.kjh.protot.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjh.protot.proj.utill.Ut;
import com.kjh.protot.proj.vo.Aram;

@Controller
public class AramController {

	public AramController() {

	}

	@RequestMapping("/usr/aram/ring")
	@ResponseBody
	public String run() {

		return "%s구역 화재.";
	}

}
