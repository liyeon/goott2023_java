package com.tech.w08;

public class Korean {
	private String nation = "대한민국";
	private String name;
	private String ssn;

	// 기본 생성자
	public Korean() {
	}
	//캡슐화임 이게 
	// 사용자 생성자
	//생성자의 매개변수로 접근은 가능하나 setter 메소드를 통한 내용은 바꿀수없다.
	public Korean(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}//

	public String getNation() {
		return nation;
	}

	public String getName() {
		return name;
	}

	public String getSsn() {
		return ssn;
	}

	@Override
	public String toString() {
		return name + " " + ssn;
	}

}//