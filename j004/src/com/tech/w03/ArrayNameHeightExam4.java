package com.tech.w03;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayNameHeightExam4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("인원수를 입력해주세요");
		int cntPerson = s.nextInt();
		String[] names = new String[cntPerson];

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
		
		
		
		/*
		 * 변수의 명명규칙
		 * 반드시 해야하는 경우
		 * - 하나 이상의 문자
		 * - 첫번째 글자는 문자가(_,$)는 가능하다.
		 * - 길이에 제한 없음
		 * - 자바의 키워드는 사용 불가하다.(int, public 등)
		 * @권장사항
		 * - 첫글자를 소문자 명사로
		 * - 의미를 담고 축약해서 만든다.
		 * == CamelCase 
		 * - 방법 합성어 ( studentScore)
		 * == Snake Type
		 * - student_score
		 */
	}// main

}// class