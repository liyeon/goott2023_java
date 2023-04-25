package com.tech.w03;

public class IfMisson {
	public static void main(String[] args) {
//		랜덤 정수를 입력받고 (100~200);
//		랜덤정수가 짝인지 홀수인지 판정
//		
//		3의 배수 
//		5의 배수인지 판정
		
		int s = (int)(Math.random()*100)+100;//0~99를 100까지 더하면 100~199
		String str="";
		if(s%2==0) {
			str=": 짝수";
		}else{
			str=": 홀수";
		}//조건문 종료
		System.out.println(s+str);
		
		if(s%3==0) {
			System.out.println(s+": 3의 배수 입니다.");
		}else if(s%5==0) {
			System.out.println(s+": 5의 배수 입니다.");
		}//조건문 종료
		
		
		// 2의 배수 3의 배수 5의 배수가 동시인 숫자
		
		if(s%2==0 && s%3==0 && s%5==0) {
			str=" : 2의 배수, 3의 배수, 5의 배수";
			
		}else {
			str =" : NO 2의 배수, 3의 배수, 5의 배수";
		}
		System.out.println(s+str);
	}//main
}//class