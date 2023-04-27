package com.tech.mission;

import java.util.Random;
import java.util.Scanner;

public class GBBGame2 {

	public static void main(String[] args) {
		/*
		 * 출력 컴 : 가위 유저 : 바위 - 유저 승
		 * 
		 * 두 값을 입력받기 Scanner Random
		 */

		Scanner s = new Scanner(System.in);
		Random r = new Random();
		while (true) {
			int cNum=0; // 컴
			int yNum=0; //사람
			System.out.println("가위바위보게임");
			System.out.println("[ 가위 : 1, 바위 : 2, 보 : 3, 종료 : 0 ]");
			System.out.println("사람 숫자 입력 : ");
			yNum = s.nextInt();
			cNum = r.nextInt(3)+1;
			String line= "====================================================";
			
			System.out.println(line);
			System.out.println("[ " + yNum + " ]");
			System.out.println("[ " + cNum + " ]");
			System.out.println("사람은 " + yNum + " 컴퓨터는 " + cNum);
			System.out.println(line);
			
			
			GBBGame2 game=new GBBGame2();
			game.judge(cNum, yNum);
			
		} // while
	}// main

	public void judge(int cNum, int yNum) {
		//가위 : 1, 바위 : 2, 보 : 3
		if((cNum==1 && yNum==3)||(cNum==2 && yNum==1)||(cNum==3 && yNum==2)) {
			System.out.println("컴퓨터가 승리했습니다.");
		}else if((yNum==1 && cNum==3)||(yNum==2 && cNum==1)||(yNum==3 && cNum==2)) {
			System.out.println("사람이 승리했습니다.");
		}else {
			System.out.println("무승부");
		}
	}//judge
}// class