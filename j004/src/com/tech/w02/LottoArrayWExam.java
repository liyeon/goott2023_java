package com.tech.w02;

import java.util.Arrays;

public class LottoArrayWExam {

	public static void main(String[] args) {
		// 1~45
		int[] arr = new int[6];

		for (int i = 0; i < arr.length; i++) {
			int num = (int) (Math.random() * 45) + 1;
			arr[i] = num;
			System.out.println("arr : "+i+">"+arr[i]);
			//중복회피 
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {//이미 입력된 값과 새로운 값이 동일한지
					i--;//제자리로 돌아가기
					break;
				} // 조건문 종료
			} // 반복문 종료
		} // 반복문 종료
		
		//정렬전
		System.out.println(Arrays.toString(arr));
		
		//정렬 후
		//오름차순정렬 1,2,3,4, 내림차순 4,3,2,1,
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}// main 종료

}// class종료