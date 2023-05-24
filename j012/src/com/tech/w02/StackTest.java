package com.tech.w02;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(100);
		stack.push(200);
		stack.push(300);
		System.out.println(stack);
		System.out.println(stack.empty()); // stack 이 비어있지 않기 때문에 false
		
		// 데이터 제거 
		System.out.println(stack.pop()); // 300 가장 나중에 들어간게 먼저 나옴
		System.out.println(stack.pop()); // 200
		System.out.println(stack.pop()); // 100 
		System.out.println(stack.empty()); // stack 이 비어있기 때문에 true
	}// main
}// class