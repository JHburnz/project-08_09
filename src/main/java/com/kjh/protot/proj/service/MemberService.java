package com.kjh.protot.proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjh.protot.proj.repository.MemberRepository;
import com.kjh.protot.proj.utill.Ut;
import com.kjh.protot.proj.vo.Member;
import com.kjh.protot.proj.vo.ResultData;

@Service
public class MemberService {
	@Autowired
	MemberRepository memberRepository;

	public ResultData<Integer> join(String loginId, String loginPw, String name, String nickname, String email,
			String cellphoneNo, String location) {
		// 로그인아이디 중복체크
		Member oldMember = getMemberByLoginId(loginId);

		if (oldMember != null) {
			return ResultData.from("F-7", Ut.f("해당 로그인아이디(%s)는 이미 사용중입니다.", loginId));
		}

		// 이름+이메일 중복체크
		oldMember = getMemberByNameAndEmail(name, email);

		if (oldMember != null) {
			return ResultData.from("F-8", Ut.f("해당 이름(%s)과 이메일(%s)은 이미 사용중입니다.", name, email));
		}

		memberRepository.join(loginId, loginPw, name, nickname, email, cellphoneNo, location);
		int id = memberRepository.getLastInsertId();

		return ResultData.from("S-1", "회원가입이 완료되었습니다.", "id", id);
	}

	private Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);
	}

	public Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}

}
