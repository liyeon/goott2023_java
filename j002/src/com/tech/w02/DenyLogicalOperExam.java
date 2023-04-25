package com.tech.w02;

public class DenyLogicalOperExam {

	public static void main(String[] args) {
		//boolean, not 함수 이해
		
		boolean play1=false;
		boolean play2=false;
		System.out.println(play1);
		
		// 역함수
		play1=!play1;//play는 true
		
		System.out.println(play1);
		
		boolean result1=play1 || play2;// or 연산자 하나만 true여도 true
		// and 입력값이 모두 true일시에 true
		
		boolean result2=play1 && play2;
		
		System.out.println(result1);
		System.out.println(result2);
		
		play1=!(!play1);//play 는 true
		System.out.println(play1);
	}
}