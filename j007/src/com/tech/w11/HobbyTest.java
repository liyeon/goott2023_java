package com.tech.w11;

public class HobbyTest {

	public static void main(String[] args) {
		/*
		 * 취미 취미1 취미2 취미3
		 * 누구의 취미 : 취미 출력
		 * 출력은 Hobby 에서 리턴
		 * 생성자를 통해서 취미 전달
		 */
		
		Hobby h1=new Hobby("홍길동","취미1", "취미2", "취미3");
		Hobby h2=new Hobby("김방방","취미4", "취미5", "취미6");
		System.out.println(h1.toString());
		System.out.println("================================");
		System.out.println(h2.toString());
	
	}//main

}//class