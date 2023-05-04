package com.tech.w04interface;

public interface MyMp3 {
	//인터페이스란
	//추상 메소드의 집합
	public void playMp3();
	public void listenFm();
	//추상메소드는 기본적으로 public 을 가짐
	//생략하면 컴파일시 자동으로 public abstract가 추가됨 public void viewPhoto(){};
	void viewPhoto();
}//interface