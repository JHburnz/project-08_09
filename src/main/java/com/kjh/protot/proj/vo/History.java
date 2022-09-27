package com.kjh.protot.proj.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {
	private int hid;
	private int id;
	public String activeDate;
	public String offDate;
	public String intel;
	public String area;
	public String ol;
	public int stat;
}
