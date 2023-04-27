package com.tech.mission;

public class DiceGameMission {

	public static void main(String[] args) {
		/*
		 * 주사위 게임 
		 * 랜덤 1~6 받고
		 * 
		 * 영수 VS 컴퓨터
		 * 큰수를 받는 사람 승리
		 * 
		 * 판정
		 * ====
		 * 결과는
		 * 영수는 3, 컴퓨터는 5 컴퓨터 승리
		 */

		int comRandom = (int)(Math.random()*6)+1;
		int personRandom = (int)(Math.random()*6)+1;
		System.out.println("[ "+comRandom+" ]");
		System.out.println("[ "+personRandom+" ]");
		String str = "";
		
		if(comRandom<personRandom) {
			str="사람이 이겼습니다.";
		}else if(comRandom>personRandom) {
			str="컴퓨터가 이겼습니다.";
		}else {
			str="동점입니다.";
		}
		System.out.println("==========================");
		System.out.println("사람은 "+personRandom+" 컴퓨터는 "+comRandom);
		System.out.println(str);
		System.out.println("==========================");
	}//

}//