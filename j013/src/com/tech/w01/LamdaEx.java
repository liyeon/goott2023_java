package com.tech.w01;

interface MyFunction {
	int calc(int x, int y);// 리턴이 있는 추상 메소드
}// interface

public class LamdaEx {
	public static void main(String[] args) {
		MyFunction add = (x, y) -> {
			return x + y;
		}; // 람다식
		MyFunction minus = (x, y) -> x - y;//람다식
		System.out.println(add.calc(1, 2));
		System.out.println(minus.calc(10, 2));
	}// main
}// class