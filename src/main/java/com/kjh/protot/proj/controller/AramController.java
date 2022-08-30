package com.kjh.protot.proj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjh.protot.proj.service.AramService;
import com.kjh.protot.proj.utill.Ut;
import com.kjh.protot.proj.vo.Aram;
import com.kjh.protot.proj.vo.Member;
import com.kjh.protot.proj.vo.ResultData;
import com.kjh.protot.proj.vo.Rq;

@Controller
public class AramController {
	AramService aramService;
	Rq rq;

	public AramController(Rq rq, AramService aramService) {
		this.aramService = aramService;
		this.rq = rq;
	}

	@RequestMapping("/usr/aram/list")
	public String showList(Model model) {
		List<Aram> arams = aramService.getArams();

		model.addAttribute("aram", arams);

		return "usr/aram/list";
	}

//	@RequestMapping("/usr/aram/list")
//	public String showList(HttpServletRequest req, Model model) {
//
//		String oL;
//
//		Member m;
//		m = rq.getLoginedMember();
//
//		oL = m.getLocation();
//
//		List<Aram> arams = aramService.getForPrintArams(oL);
//
//		model.addAttribute("arams", arams);
//
//		return "usr/aram/list";
//	}

	@RequestMapping("/usr/aram/write")
	public String write() {

		return "usr/aram/write";
	}

	@RequestMapping("/usr/aram/doWrite")
	@ResponseBody
	public String doWrite(String area, String intel) {

		String oL;

		Member m;
		m = rq.getLoginedMember();

		oL = m.getLocation();

		if (Ut.empty(area)) {
			return rq.jsHistoryBack("area(을)를 입력해주세요.");
		}

		if (Ut.empty(intel)) {
			intel = "공란";
		}

		ResultData<String> aram = aramService.writeAram(oL, area, intel);
		return rq.jsReplace((Ut.f("%s에 구역이 추가되었습니다", oL)), "/usr/aram/write");

	}

	@RequestMapping("/usr/aram/ring")
	@ResponseBody
	public String run() {

		return "%s구역 화재.";
	}
}
