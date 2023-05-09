package com.tech.w03;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutExam extends JFrame{
	public static void main(String[] args) {
		new CardLayoutExam();
	}//main
	public CardLayoutExam() {
		setTitle("카드 레이아웃");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//컨테이너 준비
		Container c = getContentPane();//담는 그릇 역할
		CardLayout cc = new CardLayout();
		c.setLayout(cc);
		
		//panel 준비
		JPanel p1,p2,p3;//선언
		
		//실제 객체 생성
		p1=new JPanel();//객체 생성
		p1.setBackground(Color.decode("#8EC0E4"));
		p1.add(new JLabel("p111"));
		
		p2=new JPanel();//객체 생성
		p2.setBackground(Color.decode("#cbe86b"));
		p2.add(new JLabel("p222"));
		
		p3=new JPanel();//객체 생성
		p3.setBackground(Color.decode("#AAABD3"));
		p3.add(new JLabel("p333"));
		
		c.add(p3, "3");
		c.add(p2, "2");
		c.add(p1, "1");
		
		cc.show(c, "2");
		
		setVisible(true);
	}//constructor
}//class