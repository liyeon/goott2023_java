package com.tech.w12;

public class Hobby {
	private String name;
	private String hobby1;
	private String hobby2;
	private String hobby3;

	public Hobby() {}

	public Hobby(String name, String hobby1, String hobby2, String hobby3) {
		this.name = name;
		this.hobby1 = hobby1;
		this.hobby2 = hobby2;
		this.hobby3 = hobby3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHobby1() {
		return hobby1;
	}

	public void setHobby1(String hobby1) {
		this.hobby1 = hobby1;
	}

	public String getHobby2() {
		return hobby2;
	}

	public void setHobby2(String hobby2) {
		this.hobby2 = hobby2;
	}

	public String getHobby3() {
		return hobby3;
	}

	public void setHobby3(String hobby3) {
		this.hobby3 = hobby3;
	}

}// class