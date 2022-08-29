package com.kjh.protot.proj.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kjh.protot.proj.vo.Aram;

@Mapper
public interface AramRepository {

	@Insert("""
			INSERT INTO `aram`
			SET workDate = NOW(),
			repairDate = NOW(),
			oL = #{oL},
			intel = #{intel},
			`area` = #{area}
					""")

	void writeAram(@Param("oL") String oL, @Param("area") String area, @Param("intel") String intel);

}
