package com.tech.w03;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutExam2 extends JFrame implements ActionListener{
	Container c;
	CardLayout card;
	JButton b1,b2,b3;
	
	public static void main(String[] args) {
		new CardLayoutExam2();
	}//main
	public CardLayoutExam2() {
		setTitle("카드 레이아웃2");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//컨테이너 준비
		c = getContentPane();//담는 그릇 역할
		card = new CardLayout();
		c.setLayout(card);
		
		//버튼의 신호를 받아서 동작하게
		b1=new JButton("1111김리연1111");
		b2=new JButton("2222김리연2222");
		b3=new JButton("3333김리연3333");
		
		b1.setFont(new Font("", Font.BOLD, 20));
		b1.setBackground(Color.decode("#19A7CE"));
		b2.setBackground(Color.decode("#8294C4"));
		b3.setBackground(Color.decode("#617A55"));
		b1.setForeground(Color.WHITE);
		b2.setForeground(Color.WHITE);
		b3.setForeground(Color.WHITE);
		b2.setFont(new Font("", Font.BOLD, 20));
		b3.setFont(new Font("", Font.BOLD, 20));
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		c.add(b1,"a");
		c.add(b2,"b");
		c.add(b3,"c");
		
		setVisible(true);
	}//constructor
	
	//버튼의 신호를 받기 위한 인터페이스 오버라이드
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("신호가나요!");
		card.next(c);
//		card.show(c, "b");
	}
}//class