package com.tech.w02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(6);
		que.add(11);
		que.add(3);
		que.add(12);

		System.out.println("que의 갯수1 : " + que.size());
		int count = que.size();
		// 데이터 꺼내기
		for (int i = 0; i < count; i++) {
			System.out.println(que.poll()); //  모든 데이터를 꺼낸다.
		}
		System.out.println("que의 갯수2 : " + que.size());
	}// main
}// class