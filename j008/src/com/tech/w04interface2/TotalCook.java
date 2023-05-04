package com.tech.w04interface2;

public class TotalCook implements BurCook, HomeCook{

	@Override
	public void makeRiceBur() {
		System.out.println("Home Rice 버거");
	}

	@Override
	public void makeBur() {
		System.out.println("Home 버거");
		
	}

	@Override
	public void makeSalad() {
		System.out.println("Home 샐러드");
	}

}//class