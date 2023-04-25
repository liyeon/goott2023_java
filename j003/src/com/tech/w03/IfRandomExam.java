package com.tech.w03;

public class IfRandomExam {

	public static void main(String[] args) {
		//0.0~0.9999까지 나오니까 0~50까지 만드려면 *50을 해야한다.
		int score = (int)(Math.random()*50)+50;
		System.out.println(score);
		
		String grade= "";
		
		if(score >=90 ) {
			grade="A";
		}else if(score >= 80) {
			grade="B";
		}else if (score >= 70) {
			grade="C";
		}else if (score>=60) {
			grade="D";
		}else {
			grade="F";
		}//조건문 종료
		System.out.println(grade+"등급입니다.");
		
		// % 나머지 연산자
		if(score % 2==1) {  //score 를 2로 나눈 나머지가 1이냐를 선택한
			System.out.println("홀수");
		}else{
			System.out.println("짝수");
		}
	}//main

}//class