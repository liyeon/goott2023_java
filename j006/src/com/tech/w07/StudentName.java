package com.tech.w07;

public class StudentName {
	private String pass;
	public String name(String s) {
		if (s.equals("홍길동")) {
			pass = "1234";
		} else if (s.equals("홍길순")) {
			pass = "5678";
		} // if
		return s;
	}// name

	// ==========getter/setter===========
	public String getPass() {
		return pass;
	}
	// ==========getter/setter===========

}// class