package com.tech.w11;

public class Hobby {
	private String name;
	private String hobby1;
	private String hobby2;
	private String hobby3;

	public Hobby(){}
	
	public Hobby(String name, String hobby1, String hobby2, String hobby3) {
		this.name=name;
		this.hobby1=hobby1;
		this.hobby2=hobby2;
		this.hobby3=hobby3;
	}
	public String getName() {
		return name;
	}

	public String getHobby1() {
		return hobby1;
	}

	public String getHobby2() {
		return hobby2;
	}

	public String getHobby3() {
		return hobby3;
	}

	
	@Override
	public String toString() {
		return getName()+"의 취미는 "+getHobby1()+" "+getHobby2()+" "+getHobby3();
	}

}//class