package com.tech.w08_2;

public class ProfessorMgrTest {
	public static void main(String[] args) {
		/*
		 * 이름을 전달하고 해당하는 비밀번호를 리턴받아 메인에서 출력
		 * 홍길동 1234 홍길순 5678
		 */
		
		StudentName sn = new StudentName();
		String name="홍길순";
		
		System.out.println(name+" 비밀번호는 "+sn.getPass(name)+"이다");
	}// main
}// class