package com.kjh.protot.proj.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjh.protot.proj.service.AramService;
import com.kjh.protot.proj.utill.Ut;
import com.kjh.protot.proj.vo.Aram;
import com.kjh.protot.proj.vo.ResultData;
import com.kjh.protot.proj.vo.Rq;

@Controller
public class AramController {
//	AramService aramService;
//	Rq rq;
//
//	public AramController(Rq rq, AramService aramService) {
//		this.aramService = aramService;
//		this.rq = rq;
//	}
//
//	@RequestMapping("/usr/aram/add")
//	public String showWrite(Model model) {
//		return "usr/article/write";
//	}
//
//	@RequestMapping("/usr/aram/doAdd")
//	@ResponseBody
//	public String doAdd(String area, String replaceUri) {
//		if (Ut.empty(area)) {
//			return rq.jsHistoryBack("area(을)를 입력해주세요.");
//		}
//
//		ResultData<String> addalarm = aramService.addAram(rq.getLoginedMemberId(), area);
//		String id = addalarm.getData1();
//
//		return rq.jsReplace(Ut.f("%d구역이 추가되었습니다", id), replaceUri);
//	}

//	@RequestMapping("/usr/aram/list")
//	public String showList(Model model, @RequestParam(defaultValue = "1") int boardId,
//			@RequestParam(defaultValue = "area") String searchKeywordTypeCode,
//			@RequestParam(defaultValue = "") String searchKeyword, @RequestParam(defaultValue = "1") int page) {
//
//		int aramsCount = aramService.getArticlesCount(searchKeywordTypeCode, searchKeyword);
//
//		int itemsCountInAPage = 10;
//		int pagesCount = (int) Math.ceil((double) aramsCount / itemsCountInAPage);
//		List<Aram> arams = aramService.getForPrintArticles(rq.getLoginedMemberId(), searchKeyword,
//				searchKeywordTypeCode, itemsCountInAPage, page);
//
//		model.addAttribute("page", page);
//		model.addAttribute("pagesCount", pagesCount);
//		model.addAttribute("aramsCount", aramsCount);
//		model.addAttribute("arams", arams);
//
//		return "usr/aram/list";
//	}
//
//	@RequestMapping("/usr/aram/ring")
//	@ResponseBody
//	public String run() {
//
//		return "%s구역 화재.";
//	}

}
