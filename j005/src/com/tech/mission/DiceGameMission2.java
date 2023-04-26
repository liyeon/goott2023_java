package com.tech.mission;

import java.util.Random;
import java.util.Scanner;

public class DiceGameMission2 {

	public static void main(String[] args) {
		//Random 사용하기
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		System.out.println("[ 사람의 주사위 굴리기 ENTER ]");
		System.out.println(s.nextLine());
		int userNum=r.nextInt(6)+1;
		
		System.out.println("[ 컴퓨터의 주사위 굴리기 ENTER ]");
		System.out.println(s.nextLine());
		int comNum=r.nextInt(6)+1;
		
		System.out.println("[ "+userNum+" ]");
		System.out.println("[ "+comNum+" ]");
		String str = "";
		
		if(comNum<userNum) {
			str="사람이 이겼습니다.";
		}else if(comNum>userNum) {
			str="컴퓨터가 이겼습니다.";
		}else {
			str="동점입니다.";
		}
		System.out.println("==========================");
		System.out.println("사람은 "+userNum+" 컴퓨터는 "+comNum);
		System.out.println(str);
		System.out.println("==========================");
	}//

}//