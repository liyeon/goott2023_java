package com.tech.w04.pri;

public class priorityExam {

	public static void main(String[] args) {
		//쓰레드의 우선순의 1~10 숫자가 높으면 우선순위는 높음
		Thread t1 = new Thread();
		Thread t2 = new Thread();
		//현재 우선순위 ( 우선순위의 기본값은 5임)
		System.out.println("priority of t1 : "+t1.getPriority());
		System.out.println("priority of t2 : "+t2.getPriority());
		
		//우선순위 변경
		t1.setPriority(9);
		t2.setPriority(1);
		System.out.println("priority of t1 : "+t1.getPriority());
		System.out.println("priority of t2 : "+t2.getPriority());
		
		//우선순위 변경 2 상수값 
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		//우선순위가 높다고 무조건 먼저 다 수행되는 것이 아닌 해당 쓰레드가 수행될 빈도수를 높여주는 것
		System.out.println("priority of t1 : "+t1.getPriority());
		System.out.println("priority of t2 : "+t2.getPriority());
	}//main

}//class