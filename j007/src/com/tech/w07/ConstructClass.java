package com.tech.w07;

public class ConstructClass {
	// 생성자 이해(Constructor)

	// 기본 생성자 default constructor
	// 생략 가능
	// 클래스의 이름과 동일하고 리턴타입이 빠져있는 메소드
	public ConstructClass() {// 사용자 생성자가 있을 때 생략 불가
	}

	// 사용자 생성자
	public ConstructClass(String name) {
		System.out.println(name);
	}

	public ConstructClass(String name, float score) {
		System.out.println(name + score);
	}
	public ConstructClass(String string, int i, int j) {
		// TODO Auto-generated constructor stub
	}

	//일반 메소드 
	public void aaa() {}
	public static void main(String[] args) {
		// 생성자 호출
		new ConstructClass();
		new ConstructClass("헝ㄱ;ㄹ덩");// 매개변수가 있는 생성자 호출
		new ConstructClass("헝ㄱ;ㄹ덩", 100.0f);
		new ConstructClass("sdfsdf", 100, 100);
	}// main
}// class