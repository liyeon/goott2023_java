package com.tech.w07.generic;

public class BoxTest {

	public static void main(String[] args) {
		Box bx = new Box();
//		bx.setData(100);
		bx.setData("100원");

//		int cnt =  (int)bx.getData();
//		System.out.println(cnt);
		String cnt2 =  (String)bx.getData();
		System.out.println(cnt2);
	}// main

}// class