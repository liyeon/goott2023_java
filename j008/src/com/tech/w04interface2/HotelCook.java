package com.tech.w04interface2;

public class HotelCook implements BurCook {

	@Override
	public void makeBur() {
		System.out.println("프리미엄 햄버거 기깔난다잉");
	}// method

	@Override
	public void makeSalad() {
		System.out.println("호텔 샐러드 기깔나징");
	}// method

}// class