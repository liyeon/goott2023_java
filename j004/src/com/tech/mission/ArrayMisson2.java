package com.tech.mission;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayMisson2 {
	public static void main(String[] args) {
		/*
		 * 10개의 요소를 저장 할 수 있는 배열 선언
		 * 배열에 성적 입력받기
		 * 50~100사이 합계, 평균, 최대점수, 최소점수 출력
		 * 
		 * 메일 제목 : 배열_김리연
		 */
		Scanner s = new Scanner(System.in);

		Integer[] arr = new Integer[5];

		int total = 0;
		int max = 0;
		int min = 110;
		double avg = 0.0;

		for (int i = 0; i < arr.length; i++) {
			System.out.print("점수를 입력하세요" + (i + 1) + ">>");
			arr[i] = s.nextInt();

			if (arr[i] < 50 || arr[i] > 100) {
				System.out.println("다시 입력해주세요>");
				i--;
				continue;
			} // if 종료

//			if (arr[i] > max) {
//				max = arr[i];
//			} else if (arr[i] < min) {
//				min = arr[i];
//			} // if 종료

			total += arr[i];
			//삼항연산자
			max = arr[i]>max?arr[i]:max;
			min = arr[i]<min?arr[i]:min;
		} // for 종료

		avg = total / (double) arr.length;

		System.out.println("=================");
		System.out.printf("최소값:%d 최대값 :%d \n점수의 합계 :%d 점수 평균 : %.1f \n", min,max,total,avg);
		System.out.println(Arrays.toString(arr));
		//sort
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		//역정렬
		Arrays.sort(arr, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr));
		// 키 토탈과 키 평균 출력
		s.close();
	}// main 종료
}// class 종료