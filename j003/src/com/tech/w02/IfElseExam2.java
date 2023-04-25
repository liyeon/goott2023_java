package com.tech.w02;

public class IfElseExam2 {

	public static void main(String[] args) {
		//if 문을 활용한 데이터 분기 
		int point = 800;
		if (point >= 900) {
			System.out.println("LEVEL1");
		}else if (point >= 800) {
			System.out.println("LEVEL2");
		}else if (point >= 700) {
			System.out.println("LEVEL3");
		}else {
			System.out.println("LEVEL0");
		}//조건문 종료
	}//main
}//class