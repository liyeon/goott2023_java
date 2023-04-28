package com.tech.w08_2;

public class StudentName {
	private String pass;

	public String getPass(String name) {
		if (name.equals("홍길동")) {
			pass = "1234";
		} else if (name.equals("홍길순")) {
			pass = "5678";
		} // if
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}// class