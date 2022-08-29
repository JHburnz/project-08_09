package com.kjh.protot.proj.service;

import org.springframework.stereotype.Service;

import com.kjh.protot.proj.repository.AramRepository;
import com.kjh.protot.proj.utill.Ut;
import com.kjh.protot.proj.vo.Aram;
import com.kjh.protot.proj.vo.ResultData;

@Service
public class AramService {
	AramRepository aramRepository;

	public AramService(AramRepository aramRepository) {
		this.aramRepository = aramRepository;
	}

	public ResultData<String> writeAram(String oL, String area, String intel) {
		aramRepository.writeAram(oL, area, intel);

		return ResultData.from("S-1", Ut.f("%s번 게시물이 생성되었습니다.", area), "area", area);
	}

//	public List<Aram> getForPrintArea(String searchKeywordTypeCode) {
//		List<Aram> areas = aramRepository.getForPrintArams(limitStart, limitTake);
//		for (Aram area : areas) {
//			updateForPrintData(actorId, area);
//		}
//
//		return areas;

}
