package com.tech.w04interface2;

public class FastCook implements BurCook {

	@Override
	public void makeBur() {
		System.out.println("버거킹 !! 햄버거!!");
	}//

	@Override
	public void makeSalad() {
		System.out.println("버거킹 샐러드 있음?");
	}//

}// class