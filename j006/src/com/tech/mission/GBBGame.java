package com.tech.mission;

import java.util.Random;
import java.util.Scanner;

public class GBBGame {

	public static void main(String[] args) {
		/*
		 * 출력 컴 : 가위 유저 : 바위 - 유저 승
		 * 
		 * 두 값을 입력받기 Scanner Random
		 */

		Scanner s = new Scanner(System.in);
		Random r = new Random();
		while (true) {
			System.out.println("[ 가위 : 1, 바위 : 2, 보 : 3, 종료 : 0 ]");
			int user = s.nextInt();
			int com = r.nextInt(3)+1;
			String line= "====================================================";
			
			
			System.out.println(line);
			switch (user) {
			case 0:
				System.out.println("종료합니다");
				return;
			case 1:
				System.out.println("가위를 선택하셨습니다.");
				if (com == 1) {
					System.out.println("컴퓨터는 가위를 선택했습니다.");
					System.out.println("비겼습니다.");
					break;
				} else if (com == 2) {
					System.out.println("컴퓨터는 바위를 선택했습니다.");
					System.out.println("졌습니다.");
					break;
				} else
					System.out.println("컴퓨터는 보를 냈습니다.");
				System.out.println("이겼습니다.");
				break;

			case 2:
				System.out.println("바위를 선택하셨습니다.");
				if (com == 1) {
					System.out.println("컴퓨터는 가위를 선택했습니다.");
					System.out.println("이겼습니다.");
					break;
				} else if (com == 2) {
					System.out.println("컴퓨터는 바위를 선택했습니다.");
					System.out.println("비겼습니다.");
					break;
				} else
					System.out.println("컴퓨터는 보를 냈습니다.");
				System.out.println("졌습니다.");
				break;

			case 3:
				System.out.println("보를 선택하셨습니다.");
				if (com == 1) {
					System.out.println("컴퓨터는 가위를 선택했습니다.");
					System.out.println("졌습니다.");
					break;
				} else if (com == 2) {
					System.out.println("컴퓨터는 바위를 선택했습니다.");
					System.out.println("이겼습니다.");
					break;
				} else
					System.out.println("컴퓨터는 보를 냈습니다.");
				System.out.println("비겼습니다.");
				break;

			default:
				System.out.println("정해진 버튼만 눌러주세요.");
			}//
			
			System.out.println(line);
			System.out.println("[ " + user + " ]");
			System.out.println("[ " + com + " ]");
			System.out.println("사람은 " + user + " 컴퓨터는 " + com);
			System.out.println(line);
		} // while
	}// main

}// class