package com.tech.w02;

public class Misson4 {

	public static void main(String[] args) {
		//삼각형 면적
		//사각형 면적 구하기
		int width = 211;
		int height = 30;
		
		int stype=4;
		float resultsquare=0;
		String typeStr = "";

		if(stype==4) {
			resultsquare=width*height;
			typeStr = "사각형 : ";
		}else if (stype==3) {
			resultsquare=(width*height)/2;
			typeStr = "삼각형 :  ";
		}//조건문 종료
		
		System.out.println(typeStr + resultsquare);
	}//main
}//class