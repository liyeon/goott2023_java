package com.tech.w03;

public class UseRunnable implements Runnable {
	private String message;

	public UseRunnable(String message) {
		this.message = message;
	}// constructor

	public static void main(String[] args) {
		new Thread(new UseRunnable("서울>")).start();
		new Thread(new UseRunnable("seoul>>")).start();

	}// main

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " : " + message);
		}
	}// override method
}// class