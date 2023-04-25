package com.tech.w04;

public class SwitchExam2 {

	public static void main(String[] args) {
		char c = 'C';
		switch (c) {
		case 'A': 
			System.out.println("A 입니다");
			break;//안에 있는 문장 전체를 빠져나간다. 
		case 'B': 
			System.out.println("B 입니다");
			break;
		default: // 나머지
			System.out.println("🍳");
			break;
		}// switch 종료
	}// main 종료

}// class 종료