package com.tech.w03;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayNameHeightExam {

	public static void main(String[] args) {
		//배열1 names 에 이름 5인을 미리 입력하고
		//배열2 heights 각각 이름의 키를 입력받아
		// 배열 1의 이름에 해당하는 키를 출력하시오
		String[] names= {"김태연", "김리연", "김태환", "홍길동", "춘향이"};
		int[] heights=new int[5];
		int total = 0;
		double avg = 0.0;
		
		Scanner s = new Scanner(System.in);
		System.out.println("키를 입력하세요>>");
		
		for (int i = 0; i < heights.length; i++) {
			heights[i] = s.nextInt();
			total+=heights[i];
			
		}
		avg = total/ names.length;
		System.out.println(avg);
		System.out.println(total);
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(heights));
		
		
		
		//키 토탈과 키 평균 출력
	}//main

}//class