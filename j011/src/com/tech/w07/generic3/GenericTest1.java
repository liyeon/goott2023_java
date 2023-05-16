package com.tech.w07.generic3;

import java.util.Arrays;
import java.util.List;

public class GenericTest1 {
	// 상한(제한)이 있는 제너릭
	public static void main(String[] args) {
//		List<Object> li = Arrays.asList(1,2,3,4,5);
//		List<Integer> li = Arrays.asList(1, 2, 3, 4, 5);
		List<Double> li = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);

		System.out.println(sumOfList(li));
	}// main

	private static double sumOfList(List<? extends Number> list) {// 타입 파라미터가 Number타입으로 제한
		double s = 0.0;
		for (Object n : list) {
			s += Double.parseDouble(n.toString());
		}
		return s;
	}// method
}// class