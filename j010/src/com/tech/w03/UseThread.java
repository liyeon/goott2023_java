package com.tech.w03;

public class UseThread extends Thread {// 쓰레드
	private String message;

	public UseThread() {
	}

	public UseThread(String message) {
		this.message = message;// 필드로 전달~
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i+" : "+message);
		}
	}

	public static void main(String[] args) {
		new UseThread("서울>>>").start();// start를 호출해야만 쓰레드가 실행된다.
		new UseThread("Seoul").start();// start를 호출해야만 쓰레드가 실행된다.
	}// main
}// class