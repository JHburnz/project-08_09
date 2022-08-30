package com.kjh.protot.proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kjh.protot.proj.repository.AramRepository;
import com.kjh.protot.proj.utill.Ut;
import com.kjh.protot.proj.vo.Aram;
import com.kjh.protot.proj.vo.Member;
import com.kjh.protot.proj.vo.ResultData;
import com.kjh.protot.proj.vo.Rq;

@Service
public class AramService {
	AramRepository aramRepository;
	Rq rq;

	public AramService(AramRepository aramRepository) {
		this.aramRepository = aramRepository;
		this.rq = rq;
	}

	public ResultData<String> writeAram(String oL, String area, String intel) {
		aramRepository.writeAram(oL, area, intel);

		return ResultData.from("S-1", Ut.f("%s번 게시물이 생성되었습니다.", area), "area", area);
	}

	public List<Aram> getArams() {
		List<Aram> arams = aramRepository.getForPrintArams();
		return arams;
	}

//	public List<Aram> getForPrintArams(String oL) {
//		List<Aram> arams = aramRepository.getForPrintArams();
//		for (Aram aram : arams) {
//			updateForPrintData(oL, aram);
//		}
//		return arams;
//	}

//	private void updateForPrintData(String oL, Aram aram) {
//		if (aram == null) {
//			return;
//		}
//
//		ResultData actorCanDeleteRd = actorCanDelete(oL, aram);
//		aram.setExtra__actorCanDelete(actorCanDeleteRd.isSuccess());
//
//		ResultData actorCanModifyRd = actorCanModify(oL, aram);
//		aram.setExtra__actorCanModify(actorCanModifyRd.isSuccess());
//	}

//	public ResultData actorCanDelete(String oL, Aram aram) {
//
//		String coL;
//
//		Member cm;
//
//		cm = rq.getLoginedMember();
//
//		coL = cm.getLocation();
//
//		if (aram == null) {
//			return ResultData.from("F-1", "게시물이 존재하지 않습니다.");
//		}
//
//		if (coL != oL) {
//			return ResultData.from("F-2", "권한이 없습니다.");
//		}
//
//		return ResultData.from("S-1", "게시물 삭제가 가능합니다.");
//	}

}
