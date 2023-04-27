package com.tech.w02;

public class KeyBoardCtrlExam {
	public static void main(String[] args) throws Exception {
		boolean run = true;
		int speed = 0;
		int keyCode = 0;

		while (run) {
			if (keyCode != 13 && keyCode != 10) { // 아스키 코드값 엔터를 의미
				System.out.println("=================================");
				System.out.println("1. 속도증가, 2.속도감소, 3.중지");
				System.out.println("==================================");
				System.out.println("선택");
			} // if
			keyCode = System.in.read();
//			System.out.println(keyCode);
			
			if(keyCode==49) {
				speed+=100;
				System.out.println("속도증가 : "+speed);
			}else if(keyCode==50) {
				speed-=100;
				System.out.println("속도감소 : "+speed);
			}else if(keyCode==51) {
				run=false;
			}//if
		} // while
		System.out.println("프로그램 종료");
	}//

}//