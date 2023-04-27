package com.tech.w01;

import java.util.Arrays;

public class ForEachExam {

	public static void main(String[] args) {
		int[] numbers= {10,20,30,40,50};
		System.out.println(Arrays.toString(numbers));
		
		for (int num : numbers) {//배열에 있는 요소들 중에서 낱개로 가져와 num에 대입시켜준다.
			System.out.print(num+"\t");
		}//for~each
	}//main
}//class