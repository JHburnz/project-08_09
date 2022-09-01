package com.kjh.protot.proj.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kjh.protot.proj.vo.Aram;

@Mapper
public interface AramRepository {

	@Insert("""
			INSERT INTO `aram`
			SET workDate = NOW(),
			repairDate = NOW(),
			ol = #{ol},
			intel = #{intel},
			`area` = #{area}
					""")

	void writeAram(@Param("ol") String ol, @Param("area") String area, @Param("intel") String intel);

	@Select("""
			SELECT A.*
			FROM `aram` AS A
			LEFT JOIN member AS M
			ON A.ol = M.location
			""")

	public List<Aram> getForPrintArams();

	// <a class="btn-text-link" href="../aram/detail?id=${aram.oL}">${aram.area}</a>
}