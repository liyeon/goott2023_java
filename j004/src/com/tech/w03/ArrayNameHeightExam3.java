package com.tech.w03;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayNameHeightExam3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// 배열1 names 에 이름 5인을 미리 입력하고
//		String[] names= {"김태연", "김리연", "김태환", "홍길동", "춘향이", "tom6"};
		String[] names = new String[6];

		int[] heights = new int[names.length];
		int total = 0;
		double avg = 0.0;
		for (int i = 0; i < names.length; i++) {
			System.out.print("이름을 입력하세요>>");
			names[i] = s.next();
			System.out.print("키를 입력하세요>>");
			heights[i] = s.nextInt();
			total += heights[i];
		}
		// 배열2 heights 각각 이름의 키를 입력받아

		System.out.println("=================");
		for (int i = 0; i < heights.length; i++) {
			System.out.println(names[i] + "의 키는 " + heights[i]);
		}
		System.out.println("=================");

		avg = (double) total / heights.length;
		System.out.println("키의 평균 : " + avg);
		System.out.println("키의 합계 : " + total);
		// 배열 1의 이름에 해당하는 키를 출력하시오
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(heights));

		// 키 토탈과 키 평균 출력
	}// main

}// class