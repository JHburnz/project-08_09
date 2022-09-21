package com.kjh.protot.proj.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kjh.protot.proj.vo.Aram;

@Mapper
public interface AramRepository {

	@Insert("""
			INSERT INTO `aram`
			SET workDate = NOW(),
			repairDate = NOW(),
			activeDate = NOW(),
			ol = #{ol},
			intel = #{intel},
			`area` = #{area},
			`stat` = 0
					""")

	void writeAram(@Param("ol") String ol, @Param("area") String area, @Param("intel") String intel);

	@Select("""
			SELECT A.*
			FROM `aram` AS A
			LEFT JOIN member AS M
			ON A.ol = M.location
			""")

	public List<Aram> getForPrintArams();

	@Update("""
			UPDATE `aram`
			SET stat = 1
			WHERE ol = #{ol} AND `area` = #{area};
									""")
	public void onStat(@Param("area") String area, @Param("ol") String ol);

	@Update("""
			UPDATE `aram`
			SET stat = 0
			WHERE ol = #{ol} AND `area` = #{area};
									""")
	public void offStat(@Param("area") String area, @Param("ol") String ol);

	@Update("""
			UPDATE `aram`
			SET activeDate = NOW()
			WHERE ol = #{ol} AND `area` = #{area};
									""")
	public void setonTime(@Param("area") String area, @Param("ol") String ol);

	@Select("""
			SELECT A.*,
			M.name AS extra__writerName
			FROM aram AS A
			LEFT JOIN member AS M
			ON A.ol = M.location
			WHERE 1
			AND A.id = #{id}
			""")
	public Aram getForPrintAram(@Param("id") int id);

	@Delete("""
			DELETE FROM `aram`
			WHERE id = #{id}
						""")

	public void deleteAram(@Param("id") int id);

	@Select("""
			SELECT A.*,
			M.name AS extra__writerName
			FROM aram AS A
			LEFT JOIN member AS M
			ON A.ol = M.location
			WHERE 1
			AND A.id = #{id}
			""")
	public Aram PrintHistory(@Param("id") int id);

	@Update("""
			UPDATE `aram`
			SET intel = #{intel}
			WHERE id = #{id}
									""")

	public void modifyAram(@Param("id") int id, @Param("area") String area, @Param("intel") String intel);

	@Update("""
			UPDATE `aram`
			SET intel = #{intel}
			WHERE id = #{id}
									""")

	public void addHis(@Param("area") String area);

	// <a class="btn-text-link" href="../aram/detail?id=${aram.ol}">${aram.area}</a>
}
