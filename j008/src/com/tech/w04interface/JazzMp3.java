package com.tech.w04interface;

public class JazzMp3 implements MyMp3 {

	@Override
	public void playMp3() {
		System.out.println("mp3 Jazz 스타일 play");
	}

	@Override
	public void listenFm() {
		System.out.println("mp3 Jazz 스타일 play 듣기 ");

	}

	@Override
	public void viewPhoto() {
		System.out.println("mp3 Jazz 스타일 가수 사진");

	}

}// class