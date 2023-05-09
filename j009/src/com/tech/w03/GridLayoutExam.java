package com.tech.w03;


import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutExam extends JFrame {
	public static void main(String[] args) {
		new GridLayoutExam();
	}// main

	public GridLayoutExam() {
		setTitle("그리드레이아웃");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//row col hgap가로  vgapㅛㅔ로
		setLayout(new GridLayout(4,2,5,10));
		//버튼 생성 컴포넌트 부착 동시에
		add(new JButton("btn1"));
		add(new JButton("btn2"));
		add(new JButton("btn3"));
		add(new JButton("btn4"));
		add(new JButton("btn5"));
		add(new JButton("btn6"));
		add(new JButton("btn7"));
		add(new JButton("btn8"));
		setVisible(true);
	}
}// class