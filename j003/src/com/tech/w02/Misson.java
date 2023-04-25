package com.tech.w02;

public class Misson {

	public static void main(String[] args) {
		//삼각형 면적
		//사각형 면적 구하기
		int width = 100;
		int height = 50;
		
		//사각형
		double recsquare=width*height;
		//삼각형
		double trisquare=(width*height)/2;
		
		System.out.println("사각형 : "+recsquare);
		System.out.println("삼각형 : "+trisquare);
	}//main

}//class