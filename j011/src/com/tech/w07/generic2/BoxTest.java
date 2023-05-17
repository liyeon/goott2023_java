package com.tech.w07.generic2;

public class BoxTest {

	public static void main(String[] args) {
		//제너릭 활용
		Box<String> bx = new Box<>(); // 객체를 선언할때 완전해짐
		bx.setData("100원");
		
		String cnt = bx.getData();
		System.out.println(cnt);
		
		Box<Integer> bx2 = new Box<>();
		bx2.setData(100);
		
		Integer number = bx2.getData();
		System.out.println(number);
	}// main

}// class