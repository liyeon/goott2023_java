package com.tech.w04;

public class SwitchExam3 {

	public static void main(String[] args) {
		//12개만 가져오고 65숫자 부터 시작
		int num =(int) (Math.random()*12)+65;
		System.out.println(num);
		switch (num) {
		case 65: System.out.println("A 입니다");break;
		case 66: System.out.println("B 입니다");break;
		case 67: System.out.println("C 입니다");break;
		case 68: System.out.println("D 입니다");break;
		case 69: System.out.println("E 입니다");break;
		case 70: System.out.println("F 입니다");break;
		case 71: System.out.println("G 입니다");break;
		case 72: System.out.println("H 입니다");break;
		case 73: System.out.println("I 입니다");break;
		case 74: System.out.println("J 입니다");break;
		default: 
			System.out.println("🍳");
			break;
		}// switch 종료
	}// main 종료

}// class 종료