package com.tech.w04;

public class SwitchExam4 {

	public static void main(String[] args) {
		//1부터 12까지 랜덤으로 숫자를 입력받아 봄 345 여름 678 가을 910 나머지 겨울
		int num =(int) (Math.random()*12)+1;
		System.out.println(num);
		switch (num) {
		case 3 :case 4 : case 5: System.out.println("!!!!봄!!!!");break;
		case 6 :case 7: case 8: System.out.println("!!!!여름!!!!");break;
		case 9 :case 10: System.out.println("!!!!가을!!!!");break;
		default: 
			System.out.println("!!!!겨울!!!!");
			break;
		}// switch 종료
	}// main 종료

}// class 종료