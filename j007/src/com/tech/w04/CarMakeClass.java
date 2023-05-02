package com.tech.w04;

import java.util.Scanner;

public class CarMakeClass {
	public static void main(String[] args) {
		// 숫자를 입력받아 1(벤츠) 2(소나타) 3(에쿠스)

		Scanner s = new Scanner(System.in);

		BenzClass bc = new BenzClass();
		EquusClass ec = new EquusClass();
		SonataClass sc = new SonataClass();

		boolean flag = true;
		// 무한루프 무한대 생산
		// -1 종료 1~3이외 값은 입력범위 초과 생산 계속
		while (flag) {
			System.out.println("==========================");
			System.out.println("1(벤츠) 2(소나타) 3(에쿠스)");
			System.out.print("번호를 입력하세요!>");
			int num = s.nextInt();
			
			switch (num) {
			case 1:
				bc.CarBase();
				bc.doJoripBenz();
				break;
			case 2:
				sc.CarBase();
				sc.doJoripSonata();
				break;
			case 3:
				ec.CarBase();
				ec.doJoripEquus();
				break;
			case -1:
				flag = false;
				System.out.println("반복 종료");
				break;
			default:
				System.out.println("생상라인 없음 다시 입력해주세요");
				break;
			}// switch~case
		} // while

	}// main
}// class