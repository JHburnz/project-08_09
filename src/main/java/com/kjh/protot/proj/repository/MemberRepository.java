package com.kjh.protot.proj.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kjh.protot.proj.vo.Member;

@Mapper
public interface MemberRepository {

	@Insert("""
			INSERT INTO `member`
			SET regDate = NOW(),
			updateDate = NOW(),
			loginId = #{loginId},
			loginPw = #{loginPw},
			`name` = #{name},
			email = #{email},
			cellphoneNo = #{cellphoneNo},
			location = #{location}
						""")
	void join(@Param("loginId") String loginId, @Param("loginPw") String loginPw, @Param("name") String name,
			@Param("email") String email, @Param("cellphoneNo") String cellphoneNo, @Param("location") String location);

	@Select("SELECT LAST_INSERT_ID()")
	int getLastInsertId();

	@Select("""
			SELECT *
			FROM `member` AS M
			WHERE M.id = #{id}
			""")
	Member getMemberById(@Param("id") int id);

	@Select("""
			SELECT *
			FROM `member` AS M
			WHERE M.loginId = #{loginId}
			""")
	Member getMemberByLoginId(@Param("loginId") String loginId);

	@Select("""
			SELECT *
			FROM `member` AS M
			WHERE M.name = #{name}
			AND M.email = #{email}
			""")
	Member getMemberByNameAndEmail(@Param("name") String name, @Param("email") String email);

//	 <if test="loginPw != null">
//	loginPw = #{loginPw},
//</if>

	@Update("""
			<script>
			UPDATE `member`
			<set>
				updateDate = NOW(),

				<if test="name != null">
					name = #{name},
				</if>
				<if test="nickname != null">
					nickname = #{nickname},
				</if>
				<if test="email != null">
					email = #{email},
				</if>
				<if test="cellphoneNo != null">
					cellphoneNo = #{cellphoneNo},
				</if>
				<if test="location != null">
					location = #{location},


			</set>
			WHERE id = #{id}
			</script>
			""")
	void modify(int id, String loginPw, String name, String email, String cellphoneNo, String location);
}