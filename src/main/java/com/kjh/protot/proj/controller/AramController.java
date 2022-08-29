package com.kjh.protot.proj.controller;

import org.springframework.stereotype.Controller;
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

	@RequestMapping("/usr/aram/write")
	public String write() {

		return "usr/aram/write";
	}

//
//	@RequestMapping("/usr/article/list")
//	public String showList(Model model, @RequestParam(defaultValue = "area") String area) {
//
//		List<Aram> aram = aramService.getForPrintArams(rq.getLoginedMemberId(), area);
//
//		model.addAttribute("area", area);
//
//		return "usr/article/list";
//	}


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
