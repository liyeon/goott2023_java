package com.tech.w02;

import java.util.Arrays;

public class SortExam2 {

	public static void main(String[] args) {
		// 선택 정렬
		//하나의 값이 선택되어서 다른 값과 비교하기
		// 정렬 알고리즘
		int[] arr2 = {30,10,50,35,2};
		int tmp;

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2.length - 1; j++) {
				if (arr2[i] > arr2[j]) {
					// 데이터 교환
					tmp = arr2[j];
					arr2[j] = arr2[i];
					arr2[i] = tmp;
				} // if 종료
			} // for j
			System.out.println((i+1)+"차정렬 : "+ Arrays.toString(arr2));
		} // 반복문 종료
		System.out.println("정렬 후 : "+ Arrays.toString(arr2));
	}// main 종료

}// class 종료