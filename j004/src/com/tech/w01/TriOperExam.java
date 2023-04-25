package com.tech.w01;

public class TriOperExam {

	public static void main(String[] args) {
		//삼항연산자
		//조건식 ? 조건이 참일때 출력 : 조건이 거짓일 때 출력
		System.out.println((10>50)?10:20);
		
		int a = (10>50)?10:20;
		System.out.println(a);
		
		String b=(10>5)?"맞다":"틀리다";
		System.out.println(b);
		
		char c=(10>5)?'O':'X';
		System.out.println(c);
	}//

}//