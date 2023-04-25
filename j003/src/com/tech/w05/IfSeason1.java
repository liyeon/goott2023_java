package com.tech.w05;

public class IfSeason1 {
	public static void main(String[] args) {
		int season = (int) (Math.random() * 12) + 1;
		System.out.println("==[ " + season + "월 ]==");
		if (season >= 3 && season <= 5) {
			System.out.println("!!!!봄!!!!");
		} else if (season >= 6 && season <= 8) {
			System.out.println("!!!!여름!!!!");
		} else if (season == 9 || season == 10) {
			System.out.println("!!!!가을!!!!");
		} else {
			System.out.println("!!!!겨울!!!!");
		} // 조건문 종료
	}// main 종료
}// class 종료