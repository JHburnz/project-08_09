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

		model.addAttribute("arams", arams);

		return "usr/aram/list";
	}

	@RequestMapping("/usr/aram/write")
	public String write() {

		return "usr/aram/write";
	}

	@RequestMapping("/usr/aram/doWrite")
	@ResponseBody
	public String doWrite(String area, String intel) {

		String ol;

		Member m;
		m = rq.getLoginedMember();

		ol = m.getLocation();

		if (Ut.empty(area)) {
			return rq.jsHistoryBack("area(을)를 입력해주세요.");
		}

		ResultData<String> aram = aramService.writeAram(ol, area, intel);
		return rq.jsReplace((Ut.f("%s에 구역이 추가되었습니다", ol)), "/usr/aram/write");

	}

	@RequestMapping("/usr/aram/kon")
	@ResponseBody
	public String kon() {
		aramService.ksetTime();
		aramService.konStat();

		return rq.jsReplace((Ut.f("%s구역이 작동", "101호 주방")), "/usr/home/main");
	}

	@RequestMapping("/usr/aram/koff")
	@ResponseBody
	public String koff() {

		aramService.koffStat();

		return rq.jsReplace("작동을 멈춤니다", "/");
	}

	@RequestMapping("/usr/aram/bon")
	@ResponseBody
	public String bon() {
		aramService.bsetTime();
		aramService.bonStat();

		return rq.jsReplace((Ut.f("%s구역이 작동", "101호 주방")), "/usr/home/main");
	}

	@RequestMapping("/usr/aram/boff")
	@ResponseBody
	public String boff() {

		aramService.boffStat();

		return rq.jsReplace("작동을 멈춤니다", "/");
	}

	@RequestMapping("/usr/aram/")
	public String ring() {

		return "/usr/aram/ring";
	}
	
	
	
}
