package com.tech.w03;

public class MoneyCount {
	/*
	 * 65430원을 만들기 위한 화폐의 갯수를 구해라 
	 * 만원 6 천원 5 백원 4 십원 3
	 */
	public void moneyPrint(int money) {
		// 만원
		int m1 = money / 10000;
		// 천원
		int m2 = (money % 10000) / 1000;
		// 백원
		int m3 = (money % 1000) / 100;
		// 십원
		int m4 = (money % 100) / 10;
		System.out.println("금액 : " + money + "원");
		System.out.println("만원 : " + m1);
		System.out.println("천원 : " + m2);
		System.out.println("백원 : " + m3);
		System.out.println("십원 : " + m4);
	}// 메소드
}// class