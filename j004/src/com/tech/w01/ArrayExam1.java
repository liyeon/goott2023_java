package com.tech.w01;

public class ArrayExam1 {

	public static void main(String[] args) {
//		int score1=0;
//		int score2=0;
//		int score3=100;
//		int score4=100;
//		int score5=20;
		
		//배열 선언과 생성
		int[] scores= new int[5];
		//index number 0부터 시작한다!
		//배열의 초기화
		scores[0]=10;
		scores[1]=20;
		scores[2]=30;
		scores[3]=40;
		scores[4]=50;
		for(int i=0; i<scores.length; i++) {
			System.out.println(scores[i]);
		}//반복문 종료
		
		
		
	}//main 종료

}//class 종료