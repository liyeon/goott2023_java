package com.tech.w02;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {
	public static void main(String[] args) {
		// Map 은 key 와 value 로 이루어짐
		Map<String, String> m = new HashMap<String, String>();
		m.put("q1", "ans1");
		m.put("q2", "ans2");
		m.put("q3", "ans3");
		// key 값은 중복이 불가능하다.
		System.out.println(m);

		// 데이터 가져오기
		System.out.println(m.get("q1"));

		// 키벨류 동시에 출력
		for (Entry<String, String> e : m.entrySet()) {
			String key = e.getKey();
			String value = e.getValue();
			System.out.println(key + " : " + value);
		}
	}// main
}// class