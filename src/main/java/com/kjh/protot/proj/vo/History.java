package com.kjh.protot.proj.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class History {

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class Aram {

		private int hid;
		private int id;
		public String activeDate;
		public String offDate;
		public String intel;
		public String area;
		public String ol;
		public int stat;
	}

}
