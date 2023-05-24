package com.tech.w02lamdathread;

//class ThreadA implements Runnable {
//	@Override
//	public void run() {
//		for (int i = 0; i < 5; i++) {
//			System.out.println("thAAA");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} // try~catch
//		} // for
//	}// run
//}// class
//
//class ThreadB implements Runnable {
//	@Override
//	public void run() {
//		for (int i = 0; i < 5; i++) {
//			System.out.println("thBBB");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} // try~catch
//		} // for
//	}// run
//}// class

public class Sample {
	public static void main(String[] args) {
//		Runnable obj1=new ThreadA();
//		Runnable obj2=new ThreadB();

		// 람다식 아닐 때
		Runnable obj1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("thAAA");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} // try~catch
				} // for
			}// 오버라이드
		};// 객체 생성

		// 람다식
		Runnable obj2 = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("thBBB");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // try~catch
			} // for
		};// 객체 생성

		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		t1.start();
		t2.start();
	}// main
}// class