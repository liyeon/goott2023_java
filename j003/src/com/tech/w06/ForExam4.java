package com.tech.w06;

public class ForExam4 {

	public static void main(String[] args) {
		int even=0, odd= 0;
		//짝수의 합계 even
		//홀수의 합계 odd
		
		
		for(int i=0; i<=10; i++) {
			// 한문장일때는 중괄호를 생략해도 된다 .
			if(i%2==0)even+=i;
			else {
				odd+=i;
			}//조건문 종료
		}//반복문 종료
		System.out.println("짝수의 합계 : "+ even);
		System.out.println("홀수의 합계 : "+odd);
		
		//초기화
		even=0;
		odd= 0;
		
		//한문장이니 중괄호 생략가능하다.
		for(int i=0; i<=1000; i=i+2)even+=i;
		System.out.println("짝수의 합계 : "+ even);
	}//main 종료
}//class 종료