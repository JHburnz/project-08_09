package com.kjh.protot.proj.service;

import org.springframework.stereotype.Service;

import com.kjh.protot.proj.service.AttrService;
import com.kjh.protot.proj.repository.MemberRepository;
import com.kjh.protot.proj.utill.Ut;
import com.kjh.protot.proj.vo.Member;
import com.kjh.protot.proj.vo.ResultData;

@Service
public class MemberService {
	MemberRepository memberRepository;
	private AttrService attrService;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
		this.attrService = attrService;
	}

	public ResultData<Integer> join(String loginId, String loginPw, String name, String email, String cellphoneNo,
			String location) {
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

		memberRepository.join(loginId, loginPw, name, email, cellphoneNo, location);
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

//	public ResultData modify(int loginedMemberId, String loginPw, String name, String email, String cellphoneNo,
//			String location) {
//		memberRepository.modify(loginedMemberId, loginPw, name, email, cellphoneNo, location );
//
//		return ResultData.from("S-1", "회원정보가 수정되었습니다.");
//
//	}

	public String genMemberModifyAuthKey(int actorId) {
		String memberModifyAuthKey = Ut.getTempPassword(10);

		attrService.setValue("member", actorId, "extra", "memberModifyAuthKey", memberModifyAuthKey,
				Ut.getDateStrLater(60 * 5));
		return memberModifyAuthKey;
	}

	public ResultData checkMemberModifyAuthKey(int actorId, String memberModifyAuthKey) {
		String saved = attrService.getValue("member", actorId, "extra", "memberModifyAuthKey");

		if (!saved.equals(memberModifyAuthKey)) {
			return ResultData.from("F-1", "일치하지 않거나 만료되었습니다.");
		}

		return ResultData.from("S-1", "정상적인 코드입니다.");
	}

}