package com.tech.mission;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayMisson {
	public static void main(String[] args) {
		/*
		 * 10개의 요소를 저장 할 수 있는 배열 선언
		 * 배열에 성적 입력받기
		 * 50~100사이 합계, 평균, 최대점수, 최소점수 출력
		 * 
		 * 메일 제목 : 배열_김리연
		 */
		Scanner s = new Scanner(System.in);

		int[] scores = new int[10];

		int total = 0;
		int max = 0;
		int min = 101;
		double avg = 0.0;

		for (int i = 0; i < scores.length; i++) {
			System.out.print("점수를 입력하세요" + (i + 1) + ">>");
			scores[i] = s.nextInt();

			if (!(scores[i] >= 50 && scores[i] <= 100)) {
				System.out.println("다시 입력해주세요>");
				i--;
				continue;
			} // if 종료

			if (scores[i] > max) {
				max = scores[i];
			} else if (scores[i] < min) {
				min = scores[i];
			} // if 종료

			total += scores[i];
		} // for 종료

		avg = total / (double) scores.length;

		System.out.println("=================");
		System.out.println(Arrays.toString(scores));
		System.out.println("최소값 : " + min);
		System.out.println("최대값 : " + max);
		System.out.println("점수의 합계 : " + total);
		System.out.println("점수 평균 : " + avg);
		System.out.println("=================");
		// 키 토탈과 키 평균 출력
		s.close();
	}// main 종료
}// class 종료