package com.tech.w02;

public class Misson3 {

	public static void main(String[] args) {
		//삼각형 면적
		//사각형 면적 구하기
		int width = 211;
		int height = 30;
		
		int stype=3;
		float resultsquare=0;
		
		if(stype==4) {
			resultsquare=width*height;
		}else if (stype==3) {
			resultsquare=(width*height)/2;
		}//조건문 종료
		
		System.out.println("면적: "+resultsquare);
	}//main
}//class