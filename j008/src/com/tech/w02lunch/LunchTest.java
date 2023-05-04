package com.tech.w02lunch;

public class LunchTest {
	public static void main(String[] args) {
		//메뉴이름, 가격, 갯수, 할인율 전달
		//토탈금액 리턴
		Lunch[] ss = new Lunch[4];
		
		ss[0] = new ChinaLunch("짜장면", 8000, 2, 20);
		ss[1] = new OrientLunch("쌀국수", 12000, 1, 30);
		ss[2] = new OrientLunch("분짜", 7000, 3,40);
		ss[3] = new WestLunch("피자",29000, 2,10);

		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
			System.out.println("총금액 : "+ss[i].getTotal()+" 할인된최종금액 : "+ss[i].getRealTotal());
			System.out.println();
		}
	}//
}//