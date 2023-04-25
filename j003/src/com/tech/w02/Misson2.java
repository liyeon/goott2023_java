package com.tech.w02;

public class Misson2 {

	public static void main(String[] args) {
		//삼각형 면적
		//사각형 면적 구하기
		int width = 211;
		int height = 30;
		
		//사각형
		double recsquare=width*height;
		//삼각형
		double trisquare=(width*height)/2;
		
		double stype=3;
		
		if(stype==4) {
			System.out.println("사각형 : "+recsquare);
		}else if (stype==3) {
			System.out.println("삼각형 : "+trisquare);
		}//조건문 종료
	}//main
}//class