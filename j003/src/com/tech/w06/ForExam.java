package com.tech.w06;

public class ForExam {

	public static void main(String[] args) {
		//반복문
		/*
		for(초기값; 조건식; 증감식) {
			표현할 문장
		}
		실행순서 : 초기값 -> 조건식 -> 문장 -> 증감식 -> [조건식->문장->증감식]
		*/
		
		
		//증가 for 문
		for (int i = 0; i < 10; i++) {
			System.out.println(i+" : 반복");
		}//반복문 종료
		System.out.println("=========================");
		for (int i = 0; i < 10; i=i+2) {
			System.out.println(i+" : 반복");
		}//반복문 종료
		System.out.println("=========================");
		//감소 for 문
		for (int i = 10; i > 0; i--) {
			System.out.println(i+" : 반복");
		}//반복문 종료
	}//main 종료
}//class 종료