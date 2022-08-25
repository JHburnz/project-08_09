package com.kjh.protot.proj.service;

import java.util.List;

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

	public ResultData<String> addAram(String area) {
		aramRepository.addAram(area);
		return ResultData.from("S-1", Ut.f("%d구역이 추가되엇습니다.", area), "area", area);
	}

}
