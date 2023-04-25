package com.tech.mission;

import java.util.Scanner;

public class ScoreExam {

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
			scores[i] = s.nextInt();
			if(scores[i] > 100 && scores[i] < 0) {
				System.out.println("0~100사이의 점수만 입력해주세요.");
				i--;
				continue;
			}
			sum += scores[i];
		}//반복문 종료
		
		avg =  (sum/(double)scores.length);
		
		System.out.println("총점 : "+sum);
		System.out.println("평균 : "+ avg);
		System.out.println("인원 : " + scores.length);
		
		s.close();
	}// main 종료
}// class 종료