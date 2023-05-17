package com.tech.w07.generic3;

import java.util.Arrays;
import java.util.List;

class MyList {
	// 상한(제한)이 없는 제너릭
	public static void printList(List<?> list) {
		for (Object elem : list) {
			System.out.print(elem+" ");
		}//foreach
		System.out.println();
	}//method

}// class

public class GenericTest2 {
	public static void main(String[] args) {
		List<Object> li = Arrays.asList(1, 2, 3, 4, 5);
		List<String> ls = Arrays.asList("one", "two", "three");
		List<Object> lo = Arrays.asList("one", "two", "three");

		// 메소드 호출
		MyList.printList(li);
		MyList.printList(ls);
		MyList.printList(lo);
	}// main
}// class