package com.tech.w03;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NoneLayoutExam extends JFrame {
	public static void main(String[] args) {
		new NoneLayoutExam();
	}// main

	public NoneLayoutExam() {
		setTitle("none레이아웃");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		JLabel la = new JLabel("Buttons");
		
		//x축 y 축
		la.setLocation(30, 50);
		la.setSize(200,20);
		la.setForeground(Color.MAGENTA);
		la.setOpaque(true);//투명도
		la.setBackground(Color.PINK);
		add(la);
		for (int i = 0; i < 9; i++) {
			JButton b = new JButton(Integer.toString(i+1));//int -> string
			int posX, posY;
			posX = (int)(Math.random()*300);
			posY = (int)(Math.random()*200);
			b.setSize(50,20);
			b.setLocation(posX, posY);
			add(b);
		}
		setVisible(true);
	}
}// class