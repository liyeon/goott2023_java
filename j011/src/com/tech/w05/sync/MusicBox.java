package com.tech.w05.sync;

public class MusicBox {

//	synchronized 적용 동기화

	public synchronized void playMusicA() {
		for (int i = 0; i < 10; i++) {
			System.out.println("가요");
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // try~catch
		} // for
	}// method

	public synchronized void playMusicB() {
		for (int i = 0; i < 10; i++) {
			System.out.println("팝송");
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // try~catch
		} // for
	}// method

	public void playMusicC() {
		for (int i = 0; i < 10; i++) {
			// synchronized 블럭 처리
			synchronized (this) {
				System.out.println("힙합");
				try {
					Thread.sleep((int) (Math.random() * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // try~catch
			} // synchronized
		} // for
	}// method
}// class