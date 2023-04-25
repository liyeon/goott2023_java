package com.tech.w02;

public class IfElseExam4 {

	public static void main(String[] args) {
		//if 문을 활용한 데이터 분기 
		int point = 800;
		String level = "";
		if (point >= 900) {
			level="LEVEL1";
		}else if (point >= 800) {
			level="LEVEL2";
		}else if (point >= 700) {
			level="LEVEL3";
		}else {
			level="LEVEL0";
		}//조건문 종료
		System.out.println(level);
	}//main
}//class