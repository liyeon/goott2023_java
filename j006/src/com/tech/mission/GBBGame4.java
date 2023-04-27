package com.tech.mission;

import java.util.Random;
import java.util.Scanner;

public class GBBGame4 {

	// final 상수활용, 숫자를 문자화
	// 바꿀 수 없음
	static final int GAWI = 1;
	static final int BAWI = 2;
	static final int BO = 3;
	static String str;
	static int cNum; // 컴
	static int yNum; // 사람

	static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);
		Random r = new Random();
		GBBGame4 game = new GBBGame4();
		System.out.println("!!!!!!!가위 바위 보 게임!!!!!!!");
		System.out.println("[ 가위 : 1, 바위 : 2, 보 : 3");
		System.out.print("사람 숫자 입력 >>");
		yNum = s.nextInt();

		String line = "====================================================";

		// 사람 숫자
		game.goAction(yNum);
		cNum = r.nextInt(3) + 1;

		System.out.println(line);
		System.out.println("사람 : [ " + str + " ]");

		// 컴퓨터 숫자
		game.goAction(cNum);
		cNum = r.nextInt(3) + 1;
		System.out.println("컴퓨터 : [ " + str + " ]");

		if (!(yNum == 1 || yNum == 2 || yNum == 3)) {// 비정상적 접근
			game.reType();
		} else {
			// 가위 : 1, 바위 : 2, 보 : 3
			game.judge(cNum, yNum);
			game.goAction(yNum);
			System.out.println("사람 : [ " + str + " ]");
		}
		System.out.println(line);

	}// main

	public void reType() {
		GBBGame4 game = new GBBGame4();
		System.out.println("다시 입력해주세요 .");
		yNum = s.nextInt();
		if (!(yNum == 1 || yNum == 2 || yNum == 3)) {// 비정상적 접근
			game.reType();
		} else {
			// 가위 : 1, 바위 : 2, 보 : 3
			game.judge(cNum, yNum);
		}
	}

	public void judge(int cNum, int yNum) {
		if ((cNum == GAWI && yNum == BO) || (cNum == BAWI && yNum == GAWI) || (cNum == BO && yNum == BAWI)) {
			System.out.println("컴퓨터가 승리했습니다.");
		} else if ((yNum == GAWI && cNum == BO) || (yNum == BAWI && cNum == GAWI) || (yNum == BO && cNum == BAWI)) {
			System.out.println("사람이 승리했습니다.");
		} else if ((yNum == BO && cNum == BO) || (yNum == BAWI && cNum == BAWI) || (yNum == GAWI && cNum == GAWI)) {
			System.out.println("무승부");
		}
	}// judge

	public void goAction(int num) {
		if (num == GAWI) {
			str = "가위";
		} else if (num == BAWI) {
			str = "바위";
		} else if (num == BO) {
			str = "보";
		} else {
			str = num + "";
		}
	}// goAction
}// class