package com.tech.w04interface;

public class TrotMp3 implements MyMp3{

	@Override
	public void playMp3() {
		System.out.println("mp3 trot 스타일 ");
	}

	@Override
	public void listenFm() {
		System.out.println("mp3 trot 스타일 play 듣기 ");		
	}

	@Override
	public void viewPhoto() {
		System.out.println("mp3 trot 가수 사진");		
	}

}
