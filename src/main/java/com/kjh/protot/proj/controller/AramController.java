package com.kjh.protot.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjh.protot.proj.service.AramService;
import com.kjh.protot.proj.utill.Ut;
import com.kjh.protot.proj.vo.Rq;

@Controller
public class AramController {
	AramService aramService;
	Rq rq;

	public AramController(Rq rq, AramService aramService) {
		this.aramService = aramService;
		this.rq = rq;
	}

	@RequestMapping("/usr/aram/add")
	public String showWrite(Model model) {
		return "usr/aram/add";
	}

	@RequestMapping("/usr/aram/doAdd")
	@ResponseBody
	public String doAdd(String area) {
		if (Ut.empty(area)) {
			return rq.jsHistoryBack("area(을)를 입력해주세요.");
		}

		return Ut.f("%d구역이 추가되었습니다", area);
	}

	@RequestMapping("/usr/aram/ring")
	@ResponseBody
	public String run() {

		return "%s구역 화재.";
	}

}
