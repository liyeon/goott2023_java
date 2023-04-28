package com.tech.w05;

public class MoneyCountTest {

	public static void main(String[] args) {
		MoneyCount mc = new MoneyCount();
		int money = 75137;
		mc.moneyPrint(money);
		int[] rArr=mc.moneyPrint(money);
		System.out.println("만원 : " + rArr[0]);
		System.out.println("천원 : " + rArr[1]);
		System.out.println("백원 : " + rArr[2]);
		System.out.println("십원 : " + rArr[3]);
		System.out.println("일원 : " + rArr[4]);
	}//main
}//class