package com.kjh.protot.proj.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	public int id;
	private String regDate;
	private String updateDate;
	private String loginId;
	private String loginPw;
	public String name;
	private String email;
	private boolean delStatus;
	private String delDate;
	private String cellphoneNo;
	private String location;

}
