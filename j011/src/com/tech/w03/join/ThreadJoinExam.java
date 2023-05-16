package com.tech.w03.join;

public class ThreadJoinExam {

	public static void main(String[] args) {
		ThreadAction thread = new ThreadAction();
		thread.start();
		System.out.println("시작");
		try {
			// join 해당 쓰레드가 끝나기 전 까지 다음 라인을 출력하지 않는다.
			System.out.println(thread.isAlive());// 쓰레드 지금 동작중인지?
			thread.join();//쓰레드 동작이 중지 될 때 까지 다음 실행 대기
			System.out.println(thread.isAlive());// 쓰레드 지금 동작중인지?
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("종료");
	}// main
}// class