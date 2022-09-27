package com.kjh.protot.proj.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aram {
	public int id;
	public String workDate;
	public String repairDate;
	public String activeDate;
	public String intel;
	public boolean status;
	public String area;
	public String ol;
	public int stat;
}
