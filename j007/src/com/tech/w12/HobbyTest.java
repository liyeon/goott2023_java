package com.tech.w12;

public class HobbyTest {

	public static void main(String[] args) {
		/*
		 * 취미 취미1 취미2 취미3
		 * 누구의 취미 : 취미 출력
		 * 출력은 Hobby 에서 리턴
		 * 생성자를 통해서 취미 전달
		 */
		
//		Hobby h1=new Hobby("홍길동","취미1", "취미2", "취미3");
		Hobby h = new Hobby();
		// setter 활용한 데이터 전달
		h.setName("김빙방");
		h.setHobby1("농구");
		h.setHobby2("축구");
		h.setHobby3("배구");
		System.out.println(h.getName() + "의 취미는 " + h.getHobby1() + " " + h.getHobby2() + " " + h.getHobby3());
	}//main

}//class