package com.kjh.protot.proj.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjh.protot.proj.service.AramService;
import com.kjh.protot.proj.vo.Aram;
import com.kjh.protot.proj.vo.Rq;

@Controller
public class HomeController {
	AramService aramService;
	Rq rq;

	public HomeController(Rq rq, AramService aramService) {
		this.aramService = aramService;
		this.rq = rq;

	}

	@RequestMapping("/usr/home/main")
	public String showMain(Model model) {

		List<Aram> arams = aramService.getArams();

		model.addAttribute("arams", arams);
		return "usr/home/main";
	}

	@RequestMapping("/")
	public String showRoot() {
		return "redirect:/usr/home/main";
	}
}