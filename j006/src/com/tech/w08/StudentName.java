package com.tech.w08;

public class StudentName {
	private String pass;

	public void passSet(String name) {
		if (name.equals("홍길동")) {
			pass = "1234";
		} else if (name.equals("홍길순")) {
			pass = "5678";
		} // if
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}// class