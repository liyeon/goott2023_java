package com.tech.w02;

public class IfElseExam3 {

	public static void main(String[] args) {
		//if 문을 활용한 데이터 분기 
		int score = 80;
		String grade="";//초기화
		//변수 = 메모리 안에 
		if (score>=90) {
			grade="90점대 점수";
		}else if (score>=80) {
			grade="80점대 점수";
		}else if (score>=70) {
			grade="70점대 점수";
		}else if (score>=60) {
			grade="60점대 점수";
		}else {
			grade="나머지";
		}//조건문 종료
		System.out.println(grade);
	}//main
}//class