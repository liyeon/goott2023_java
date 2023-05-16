package com.tech.w05.sync;

public class MusicPlayer extends Thread {
	int type;
	MusicBox musicBox;

	public MusicPlayer() {
	}// constructor

	public MusicPlayer(int type, MusicBox musicBox) {
		this.type = type;
		this.musicBox = musicBox;
	}// constructor

	@Override
	public void run() {
		switch (type) {
		case 1:
			System.out.println("쓰레드 동작" + Thread.currentThread().getName()+" : "+Thread.currentThread().getPriority());
			musicBox.playMusicA();
			break;
		case 2:
			System.out.println("쓰레드 동작" + Thread.currentThread().getName()+" : "+Thread.currentThread().getPriority());
			musicBox.playMusicB();
			break;
		case 3:
			System.out.println("쓰레드 동작" + Thread.currentThread().getName()+" : "+Thread.currentThread().getPriority());
			musicBox.playMusicC();
			break;
		default:
			break;
		}
		super.run();
	}// override method
}//