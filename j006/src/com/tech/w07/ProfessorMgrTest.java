package com.tech.w07;

public class ProfessorMgrTest {
	public static void main(String[] args) {
		/*
		 * 이름을 전달하고 해당하는 비밀번호를 리턴받아 메인에서 출력
		 * 홍길동 1234 홍길순 5678
		 */
		
		StudentName sn = new StudentName();
		String s= sn.name("홍길순");
		
		StudentName sn2 = new StudentName();
		String s2 = sn2.name("홍길동");
		
		System.out.println(s+"의 비밀번호는"+sn.getPass());
		System.out.println(s2+"의 비밀번호는"+sn2.getPass());
	}// main
}// class