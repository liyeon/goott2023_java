package com.tech.w01;

import javax.swing.JFrame;

public class FrameTest {
	//Swing
	public static void main(String[] args) {
		JFrame f = new JFrame();//객체 생성
		f.setSize(900,500);//가로, 세로
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x버튼 누르면 콘솔 종료되게
		f.setVisible(true);
	}//main
}//class 