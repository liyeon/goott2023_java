package com.tech.w02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionSortTest {
	public static void main(String[] args) {
		String[] sample = { "a", "b", "d", "c" };
		List<String> list = Arrays.asList(sample);// 배열을 리스트로 변환 시키기
		System.out.println(list);

		// 오름차순 정렬
		Collections.sort(list);
		System.out.println(list);
		
		// 내림차순
		Collections.sort(list, Collections.reverseOrder()); // 정렬에 대한 역정렬
		System.out.println(list);
		
		Collections.reverse(list); // 그냥 정렬을 바꿔줌
		System.out.println(list);
	}// main
}// class