package com.kjh.protot.proj.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kjh.protot.proj.vo.Aram;

@Mapper
public interface AramRepository {
//	public void addAram(@Param("area") String area);

//	@Select("""
//			<script>
//			SELECT *
//			FROM `aram`
//			WHERE id = #{id}
//			</script>
//			""")
//	public Aram getArticle(int id);
//
//	@Select("""
//			<script>
//			SELECT COUNT(*) AS cnt
//			FROM article AS A
//			WHERE 1
//			<if test="boardId != 0">
//				AND A.boardId = #{boardId}
//			</if>
//			<if test="searchKeyword != ''">
//				<choose>
//					<when test="searchKeywordTypeCode == 'title'">
//						AND A.title LIKE CONCAT('%', #{searchKeyword}, '%')
//					</when>
//					<when test="searchKeywordTypeCode == 'body'">
//						AND A.body LIKE CONCAT('%', #{searchKeyword}, '%')
//					</when>
//					<otherwise>
//						AND (
//							A.title LIKE CONCAT('%', #{searchKeyword}, '%')
//							OR
//							A.body LIKE CONCAT('%', #{searchKeyword}, '%')
//						)
//					</otherwise>
//				</choose>
//			</if>
//			</script>
//			""")
//	public int getArticlesCount(String searchKeywordTypeCode, String searchKeyword);
//
//	@Select("""
//			<script>
//				SELECT A.*,
//				M.nickname AS extra__writerName
//				FROM article AS A
//				LEFT JOIN member AS M
//				ON A.memberId = M.id
//				WHERE 1
//				<if test="boardId != 0">
//					AND A.boardId = #{boardId}
//				</if>
//				<if test="searchKeyword != ''">
//					<choose>
//						<when test="searchKeywordTypeCode == 'title'">
//							AND A.title LIKE CONCAT('%', #{searchKeyword}, '%')
//						</when>
//						<when test="searchKeywordTypeCode == 'body'">
//							AND A.body LIKE CONCAT('%', #{searchKeyword}, '%')
//						</when>
//						<otherwise>
//							AND (
//								A.title LIKE CONCAT('%', #{searchKeyword}, '%')
//								OR
//								A.body LIKE CONCAT('%', #{searchKeyword}, '%')
//							)
//						</otherwise>
//					</choose>
//				</if>
//				ORDER BY A.id DESC
//				<if test="limitTake != -1">
//					LIMIT #{limitStart}, #{limitTake}
//				</if>
//			</script>
//			""")
//	public List<Aram> getForPrintArticles(String searchKeyword, String searchKeywordTypeCode, int limitStart,
//			int limitTake);

}
