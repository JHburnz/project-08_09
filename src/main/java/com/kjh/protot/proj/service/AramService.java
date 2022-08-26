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

	public ResultData<String> addAram(String area, String intel, String oL) {

		System.out.println(area);
		aramRepository.addAram(area, oL, intel);
		return ResultData.from("S-1", Ut.f("%s구역이 추가되엇습니다.", area), "id", area);
	}

	public Aram writeAram(String area, String intel) {
		return aramRepository.writeAram(area, intel);

	}

//	public List<Aram> getForPrintArea(String searchKeywordTypeCode) {
//		List<Aram> areas = aramRepository.getForPrintArams(limitStart, limitTake);
//		for (Aram area : areas) {
//			updateForPrintData(actorId, area);
//		}
//
//		return areas;

}
