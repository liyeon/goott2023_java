package com.tech.w09;

public class ScoreTest {
	public static void main(String[] args) {
		/*
		 * 국어 영어 수학 점수 전달
		 * 홍길동의 총점 300
		 * 홍길동의 평균 100
		 * 계산은 score에서 리턴
		 * 생성자를 통해서 점수 전달
		 */

		Score s = new Score("홍길동", 37, 95, 83);
		System.out.println(s.getName()+"의 총점 "+s.getTotal());
		System.out.println(s.getName()+"의 평균 "+s.getAvg());
	}// main
}// class