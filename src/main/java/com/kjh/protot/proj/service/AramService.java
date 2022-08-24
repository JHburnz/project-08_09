package com.kjh.protot.proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kjh.protot.proj.repository.AramRepository;
import com.kjh.protot.proj.utill.Ut;
import com.kjh.protot.proj.vo.Aram;
import com.kjh.protot.proj.vo.ResultData;

@Service
public class AramService {
//	AramRepository aramRepository;
//
//	public AramService(AramRepository aramRepository) {
//		this.aramRepository = aramRepository;
//	}
//
//	public ResultData<String> addAram(int memberId, String area) {
//		aramRepository.addAram(area);
//		return ResultData.from("S-1", Ut.f("%d구역이 추가되엇습니다.", area), "area", area);
//	}

//	public int getArticlesCount(String searchKeywordTypeCode, String searchKeyword) {
//		return aramRepository.getArticlesCount(searchKeywordTypeCode, searchKeyword);
//	}
//
//	public List<Aram> getForPrintArticles(int actorId, String searchKeyword, String searchKeywordTypeCode,
//			int itemsCountInAPage, int page) {
//		int limitStart = (page - 1) * itemsCountInAPage;
//		int limitTake = itemsCountInAPage;
//
//		List<Aram> arams = aramRepository.getForPrintArticles(searchKeyword, searchKeywordTypeCode, limitStart,
//				limitTake);
//
//		return arams;
//	}
//
//	public ResultData actorCanModify(int actorId, Aram Aram) {
//		if (Aram == null) {
//			return ResultData.from("F-1", "게시물이 존재하지 않습니다.");
//		}
//
//		return ResultData.from("S-1", "게시물 수정이 가능합니다.");
//	}

}
