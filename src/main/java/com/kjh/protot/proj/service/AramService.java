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

	public ResultData konStat() {
		aramRepository.konStat();
		return ResultData.from("S-1", "101 주방 화재");
	}

	public ResultData koffStat() {
		aramRepository.koffStat();
		return ResultData.from("S-2", "101 주방 멈춤");
	}

	public ResultData bonStat() {
		aramRepository.bonStat();
		return ResultData.from("S-1", "101 안방 화재");
	}

	public ResultData boffStat() {
		aramRepository.boffStat();
		return ResultData.from("S-2", "101 안방 멈춤");
	}

	public ResultData ksetTime() {
		aramRepository.ksetTime();
		return ResultData.from("S-3", "시간 설정");
	}

	public ResultData bsetTime() {
		aramRepository.bsetTime();
		return ResultData.from("S-3", "시간 설정");
	}

}
