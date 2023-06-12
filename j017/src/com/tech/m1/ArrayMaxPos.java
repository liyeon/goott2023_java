package com.tech.m1;

import java.util.Arrays;

public class ArrayMaxPos {
	public static void main(String[] args) {
		int[] list = new int[10];
		int max = list[0];
		int maxIndex = 0;
		int min = 1000;
		int minIndex = 0;
		
		for (int i = 0; i < 10; i++) {
			int a = (int) (Math.random() * 50) + 1;
			list[i] = a;
			for (int j = 0; j < i; j++) { // 중복 제거
				if (list[i] == list[j])
					i--;
			} // for j
		} // for i
		
		System.out.println(Arrays.toString(list));

		for (int i = 0; i < list.length; i++) {
			if (list[i] > max) {
				max = list[i];
				maxIndex = i;
			}
			if(list[i] < min) {
				min = list[i];
				minIndex=i;
				
			}
		}//for
		System.out.println("최대값 : "+max);
		System.out.println("최대값 인덱스 : "+maxIndex);
		System.out.println("최소값 : "+min);
		System.out.println("최소값 인덱스 : "+minIndex);
	}// main

}// class