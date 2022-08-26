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

	@RequestMapping("/usr/aram/add")
	public String add() {

		return "usr/aram/add";
	}

	@RequestMapping("/usr/aram/doAdd")
	@ResponseBody
	public String doAdd(String area, String intel) {
		if (Ut.empty(area)) {
			return rq.jsHistoryBack("area(을)를 입력해주세요.");
		}

		Member m = rq.getLoginedMember();

		if (intel == "") {
			intel = "공란";
		}

		ResultData<String> addAramRd = aramService.addAram(m.getLocation(), area, intel);

		System.out.println("작동");

		return rq.jsReplace(Ut.f("%s호 구역이 추가되엇스빈다", addAramRd.getData1()), "/usr/aram/add");

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

	@RequestMapping("/usr/aram/ring")
	@ResponseBody
	public String run() {

		return "%s구역 화재.";
	}

	@RequestMapping("/usr/aram/write")
	@ResponseBody
	public Aram write(String area, String intel) {
		Aram aram = aramService.writeAram(area, intel);
		return aram;
	}

}
