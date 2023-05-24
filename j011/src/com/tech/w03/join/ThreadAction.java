package com.tech.w03.join;

public class ThreadAction extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("마이 쓰레드"+i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//try~catch
		}//for
		System.out.println("run");
	}//run
}//class