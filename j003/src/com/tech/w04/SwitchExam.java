package com.tech.w04;

public class SwitchExam {

	public static void main(String[] args) {
		// 랜덤 숫자가 1~6까지 범위 숫자 추출
		int num = (int) (Math.random() * 6) + 1;
		// 주사위 놀이 형식
		switch (num) {
		case 1: // 키값의 경우의 수를 표현한다.
			// 표현식
			System.out.println("🎲 [ 1 ]");
			break;
		case 2: 
			System.out.println("🎲 [ 2 ]");
			break;
		case 3:
			System.out.println("🎲 [ 3 ]");
			break;
		case 4: 
			System.out.println("🎲 [ 4 ]");
			break;
		case 5: 
			System.out.println("🎲 [ 5 ]");
			break;
		case 6: 
			System.out.println("🎲 [ 6 ]");
			break;
		default: // 나머지
			System.out.println("🎲");
			break;
		}// switch 종료
	}// main 종료

}// class 종료