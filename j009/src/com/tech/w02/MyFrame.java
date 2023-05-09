package com.tech.w02;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public MyFrame() {
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		// 프레임(자바 화면) 크기
		Dimension frameSize = getSize();
		// 모니터 크기
		Dimension screenSize = kit.getScreenSize();
		// (모니터화면 가로 - 프레임화면 가로) / 2, (모니터화면 세로 - 프레임화면 세로) / 2
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		///j009/src/com/tech/w02/apple.png
		Image img=kit.getImage("src\\com\\tech\\w02\\apple.png");
		setIconImage(img);
		
		//컴포넌트 추가
		setLayout( new FlowLayout());
		JButton btn1 = new JButton("btn1");
		this.add(btn1);
		JButton btn2 = new JButton("btn2");
		this.add(btn2);
		JButton btn3 = new JButton("btn3");
		this.add(btn3);
		JButton btn4 = new JButton("btn4");
		this.add(btn4);
		JButton btn5 = new JButton("btn5");
		this.add(btn5);
		setVisible(true);
	}//
}//class