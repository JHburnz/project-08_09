package com.kjh.protot.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjh.protot.proj.service.MemberService;
import com.kjh.protot.proj.utill.Ut;
import com.kjh.protot.proj.vo.Member;
import com.kjh.protot.proj.vo.ResultData;
import com.kjh.protot.proj.vo.Rq;

@Controller
public class MemberController {
	private MemberService memberService;
	private Rq rq;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
		this.rq = rq;
	}

	// /usr/member/doJoin?loginId=123&loginPw=123&name=123&nickname=123&email=123&cellphoneNo=123&location=123
	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public ResultData<Member> doJoin(String loginId, String loginPw, String name, String email, String cellphoneNo,
			String location) {

		if (Ut.empty(loginId)) {
			return ResultData.from("F-1", "loginId(을)를 입력해주세요.");
		}

		if (Ut.empty(loginPw)) {
			return ResultData.from("F-2", "loginPw(을)를 입력해주세요.");
		}

		if (Ut.empty(name)) {
			return ResultData.from("F-3", "name(을)를 입력해주세요.");
		}

		if (Ut.empty(email)) {
			return ResultData.from("F-5", "email(을)를 입력해주세요.");
		}

		if (Ut.empty(cellphoneNo)) {
			return ResultData.from("F-6", "cellphoneNo(을)를 입력해주세요.");
		}

		if (Ut.empty(location)) {
			return ResultData.from("F-7", "location(을)를 입력해주세요.");
		}

		ResultData<Integer> joinRd = memberService.join(loginId, loginPw, name, email, cellphoneNo, location);

		if (joinRd.isFail()) {
			return (ResultData) joinRd;
		}

		Member member = memberService.getMemberById(joinRd.getData1());

		return ResultData.newData(joinRd, "member", member);
	}

	@RequestMapping("/usr/member/doLogout")
	@ResponseBody
	public String doLogout() {
		if (!rq.isLogined()) {
			return rq.jsHistoryBack("이미 로그아웃 상태입니다.");
		}

		rq.logout();

		return rq.jsReplace("로그아웃 되었습니다.", "/");
	}

	@RequestMapping("/usr/member/login")
	public String showLogin() {
		return "usr/member/login";
	}

	@RequestMapping("/usr/member/doLogin")
	@ResponseBody
	public String doLogin(String loginId, String loginPw) {
		if (rq.isLogined()) {
			return rq.jsHistoryBack("이미 로그인되었습니다.");
		}

		if (Ut.empty(loginId)) {
			return rq.jsHistoryBack("loginId(을)를 입력해주세요.");
		}

		if (Ut.empty(loginPw)) {
			return rq.jsHistoryBack("loginPw(을)를 입력해주세요.");
		}

		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			return rq.jsHistoryBack("존재하지 않은 로그인아이디 입니다.");
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return rq.jsHistoryBack("비밀번호가 일치하지 않습니다.");
		}

		rq.login(member);

		return rq.jsReplace(Ut.f("%s님 환영합니다.", member.name), "/");
	}

	@RequestMapping("/usr/member/myPage")
	public String showMyPage() {
		return "usr/member/myPage";
	}

	@RequestMapping("/usr/member/checkPassword")
	public String showCheckPassword() {
		return "usr/member/checkPassword";
	}

	@RequestMapping("/usr/member/doCheckPassword")
	@ResponseBody
	public String doCheckPassword(String loginPw, String replaceUri) {
		if (Ut.empty(loginPw)) {
			return rq.jsHistoryBack("loginPw(을)를 입력해주세요.");
		}

		if (rq.getLoginedMember().getLoginPw().equals(loginPw) == false) {
			return rq.jsHistoryBack("비밀번호가 일치하지 않습니다.");
		}

		return rq.jsReplace("", replaceUri);
	}

	@RequestMapping("/usr/member/modify")
	public String showModify(String memberModifyAuthKey) {
		if (Ut.empty(memberModifyAuthKey)) {
			return rq.historyBackJsOnView("memberModifyAuthKey(이)가 필요합니다.");
		}

		return "usr/member/modify";
	}

	@RequestMapping("/usr/member/doModify")
	@ResponseBody
	public String doModify(String loginPw, String name, String email, String cellphoneNo, String location) {

		if (Ut.empty(loginPw)) {
			loginPw = null;
		}

		if (Ut.empty(name)) {
			return rq.jsHistoryBack("이름(을) 입력해주세요.");
		}

		if (Ut.empty(email)) {
			return rq.jsHistoryBack("이메일(을) 입력해주세요.");
		}

		if (Ut.empty(cellphoneNo)) {
			return rq.jsHistoryBack("휴대전화번호(을) 입력해주세요.");
		}

		if (Ut.empty(location)) {
			return rq.jsHistoryBack("위치를(을) 입력해주세요.");
		}

		ResultData modifyRd = memberService.modify(rq.getLoginedMemberId(), loginPw, name, email, cellphoneNo,
				location);

		return rq.jsReplace(modifyRd.getMsg(), "/");
	}
}