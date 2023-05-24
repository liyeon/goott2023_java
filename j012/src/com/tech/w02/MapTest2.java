package com.tech.w02;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {
	public static void main(String[] args) {
		// Map 은 key 와 value 로 이루어짐
		Map<String, Integer> m = new HashMap<>();
//		m.put("to", 2);
		// 키값에 플러스 할 수 있음
		String[] sample = { "to", "be", "or", "not", "to", "be", "is", "a", "a", "a", "problem", "to", "be" };

		for (String a : sample) {
			Integer freq = m.get(a);
//			System.out.println(freq);
//			m.put(a, 1);
			//null 이면 1 아니면 +1
			m.put(a, freq==null ? 1:freq+1);
			System.out.println(a);
		}
		
		
		System.out.println(m);
	}// main
}// class