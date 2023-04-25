package com.tech.mission;

import java.util.Scanner;

public class ScoreExam2 {

	public static void main(String[] args) {
		/*
		 * 배열 사이즈는 5 점수를 입력받아 배열에 저장 평균 합계 인원 출력 
		 * 배열의 이름 : scores 메일 제목 : 배열 성적처리_ 김리연
		 * 배열로 총점 매기기 = 입력제한 (0~100) 캡쳐해서 메일로 ( tbsic@daum.net )
		 */

		int scores[] = new int[5];
		int sum = 0;
		Double avg = 0.0;

		Scanner s = new Scanner(System.in);
		for (int i = 0; i < scores.length; i++) {
			System.out.print(i + 1 + "번 점수 입력 > ");
			scores[i] = s.nextInt();//배열에 입력한 값 받기
			//입력데이터 제한
			if(!(scores[i]>=0&&scores[i]<=100)) {
				System.out.println("다시 입력해주세요>");
				//다시 넣기
				i--;//인덱스를 조정해서 다시 넣기 
				continue;
			}//조건문 종료
			sum = sum+scores[i];//누적
		}//반복문 종료
		
		avg =  (sum/(double)scores.length);
		
		System.out.println("총점 : "+sum);
		System.out.println("평균 : "+ avg);
		System.out.println("인원 : " + scores.length);
		
		s.close();
	}// main 종료
}// class 종료