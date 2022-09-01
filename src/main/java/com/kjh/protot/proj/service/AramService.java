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

	public ResultData<String> writeAram(String ol, String area, String intel) {
		aramRepository.writeAram(ol, area, intel);

		return ResultData.from("S-1", Ut.f("%s번 게시물이 생성되었습니다.", area), "area", area);
	}

	public List<Aram> getArams() {
		List<Aram> arams = aramRepository.getForPrintArams();
		return arams;
	}


}
