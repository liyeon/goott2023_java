package com.tech.w01;

import javax.swing.JFrame;

public class MyFrame {
	public MyFrame() {
		System.out.println("기본생성자호출");
		JFrame f = new JFrame();
		f.setSize(500,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}//class