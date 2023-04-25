package com.tech.w02;

public class IfExam {

	public static void main(String[] args) {
		// if 문 형식
		/*
		if(조건식) {
			조건식이 참일 때 표현하고 싶은 문장;
		}else {
			조건식이 거짓일 때 표현하고 싶은 문장;
		}
		*/
		
		int score=80;
		System.out.println(score>=90);
		//점수가 90 이상이면 pass로 조건 단다.
		if (score>=90) {
			System.out.println("시험통과ㅇㅇ ");
		}else{
			System.out.println("시험 불합격");
		}
	}//메인 메소드 
}//class