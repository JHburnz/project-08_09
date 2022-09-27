package com.kjh.protot.proj.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjh.protot.proj.service.AramService;
import com.kjh.protot.proj.utill.Ut;
import com.kjh.protot.proj.vo.Aram;
import com.kjh.protot.proj.vo.History;
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

	@RequestMapping("/usr/aram/detail")
	public String showDetail(Model model, int id) {
		Aram aram = aramService.getForPrintAram(id);

		model.addAttribute("aram", aram);

		return "usr/aram/detail";
	}

	@RequestMapping("/usr/aram/button")
	public String button() {

		return "usr/aram/button";
	}

	@RequestMapping("/usr/aram/on")
	@ResponseBody
	public String on(String area, String ol) {

		aramService.setTime(area, ol);
		aramService.onStat(area, ol);
		aramService.addHis(area,ol);
		
		return rq.jsReplace((Ut.f("%s구역이 작동", area)), "/usr/aram/button");
	}

	@RequestMapping("/usr/aram/off")
	@ResponseBody
	public String off(String area, String ol) {

		aramService.setTime(area, ol);
		aramService.offStat(area, ol);

		return rq.jsReplace((Ut.f("%s구역이 작동", area)), "/usr/aram/button");
	}

	@RequestMapping("/usr/aram/doDelete")
	@ResponseBody
	public String doDelete(int id) {

		Aram aram = aramService.getForPrintAram(id);

		aramService.deleteAram(id);

		return Ut.jsReplace(Ut.f("%d번 게시물을 삭제하였습니다.", id), "../aram/list");
	}

	@RequestMapping("/usr/aram/modify")
	public String showModify(Model model, int id) {

		Aram aram = aramService.getForPrintAram(id);

		model.addAttribute("aram", aram);

		return "usr/aram/modify";
	}

	@RequestMapping("/usr/aram/doModify")
	@ResponseBody
	public String doModify(int id, String area, String intel) {

		Aram aram = aramService.getForPrintAram(id);

		aramService.modifyAram(id, area, intel);

		return rq.jsReplace(Ut.f("%d번 글이 수정되었습니다.", id), Ut.f("../aram/detail?id=%d", id));
	}

	@RequestMapping("/usr/aram/history")
	public String showHistory(Model model) {

		List<History> historys = aramService.getHis();

		model.addAttribute("historys", historys);

		return "usr/aram/history";
	}

}
