package com.tech.w01;

enum Season{
	봄,여름,가을,겨울,겨울2
}

public class EnumExam {
	//Enum Class 를 활용한 열거형 클래스 
	public static void main(String[] args) {
		//for each 사용
		for(Season sea : Season.values()) {
			System.out.print(sea+" | ");
		}//
		//직접 접근
		Season season = Season.가을;
		System.out.println();
		System.out.println("다이렉트로 접근 : "+season);
	}//
}//class