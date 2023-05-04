package com.tech.w02lunch2;

public class LunchTest {
	public static void main(String[] args) {
		// 메뉴이름, 가격, 갯수, 할인율 전달
		// 토탈금액 리턴
		Lunch[] lunch = new Lunch[4];
		lunch[0] = new ChinaLunch("짜장면", 8000, 2, 0.4);
		lunch[1] = new OrientLunch("쌀국수", 12000, 1, 0.3);
		lunch[2] = new OrientLunch("분짜", 7000, 3, 0.2);
		lunch[3] = new WestLunch("피자", 29000, 2, 0.1);

		for (int i = 0; i < lunch.length; i++) {
			System.out.println("===========================");
			System.out.println(lunch[i]);
			System.out.println("총금액 : " + lunch[i].getTotal());
		}
	}//
}//