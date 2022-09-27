package com.kjh.protot.proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kjh.protot.proj.repository.AramRepository;
import com.kjh.protot.proj.utill.Ut;
import com.kjh.protot.proj.vo.Aram;
import com.kjh.protot.proj.vo.History;
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

	public ResultData onStat(String area, String ol) {
		aramRepository.onStat(area, ol);
		return ResultData.from("S-1", "101 주방 화재");
	}

	public ResultData offStat(String area, String ol) {
		aramRepository.offStat(area, ol);
		return ResultData.from("S-2", "101 주방 멈춤");
	}

	public ResultData setTime(String area, String ol) {
		aramRepository.setonTime(area, ol);
		return ResultData.from("S-3", "시간 설정");
	}

	public Aram getForPrintAram(int id) {
		return aramRepository.getForPrintAram(id);

	}

	public void deleteAram(int id) {
		aramRepository.deleteAram(id);
	}

	public ResultData<Aram> modifyAram(int id, String area, String intel) {
		aramRepository.modifyAram(id, area, intel);

		Aram aram = getForPrintAram(id);

		return ResultData.from("S-1", "게시물이 수정되었습니다");
	}

	public List<History> getHis() {
		List<History> Historys = aramRepository.getForPrintHis();

		return Historys;
	}

	public ResultData addHis(String area,String ol) {

		Aram aram = aramRepository.getAram(area,ol);

		aramRepository.addHis(aram.area, aram.activeDate, aram.intel, aram.id, aram.ol);

		return ResultData.from("S-1", "기록추가");
	}

}
