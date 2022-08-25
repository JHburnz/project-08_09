package com.kjh.protot.proj.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AramRepository {

	@Insert("""
			INSERT INTO `aram`
			SET workDate = NOW(),
			repairDate = NOW(),
			`area` = #{area}
			}
						""")
	void addAram(@Param("area") String area);

}
