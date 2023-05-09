package com.tech.w03;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JoinForm2 extends JFrame {
	public static void main(String[] args) {
		new JoinForm2();
	}

	public JoinForm2() {
		setTitle("회원가입");
		setSize(400, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// panel 준비
		JPanel p = new JPanel();
		p.setLayout(null);
		
		//panel 색상 변경
		p.setBackground(Color.decode("#be99ff"));
		// label 준비
		JLabel lTitle = new JLabel("Member Join");
		JLabel l1 = new JLabel("ID");
		JLabel l2 = new JLabel("PW");
		JLabel l3 = new JLabel("NAME");
		
		//타이틀 수정
		lTitle.setFont(new Font("impact", Font.BOLD, 20));
		//text Field 준비 사이즈 지정
		JTextField tf1 = new JTextField(15);
		JTextField tf2 = new JTextField(15);
		JTextField tf3 = new JTextField(15);
	
		//button 준비
		JButton b1 = new JButton("JOIN");
		JButton b2 = new JButton("수정");
		JButton b3 = new JButton("삭제");
		
		// panel에 준비된 컴포넌트 부착
		p.add(lTitle);
		
		p.add(l1);
		p.add(l2);
		p.add(l3);
		
		p.add(tf1);
		p.add(tf2);
		p.add(tf3);
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		
		// 위치 지정
		int y1=30;
		int x1 = 100;
		// set size와 setLocation을 합친거
//		setBounds(x, y, WIDTH, HEIGHT);
		lTitle.setBounds(20, 20, 200, 20);
		
		l1.setBounds(20, 50, 50, 20);
		l2.setBounds(20, 50+y1*1, 50, 20);
		l3.setBounds(20, 50+y1*2, 50, 20);
		
		tf1.setBounds(20+x1, 50, 150, 20);
		tf2.setBounds(20+x1, 50+y1*1, 150, 20);
		tf3.setBounds(20+x1, 50+y1*2, 150, 20);
		
		b1.setBackground(Color.decode("#ffa47a"));
		b2.setBackground(Color.decode("#ffc7e2"));
		b3.setBackground(Color.decode("#ff0090"));
		b1.setBounds(20, 50+y1*4, 100, 30);
		b2.setBounds(140, 50+y1*4, 100, 30);
		b3.setBounds(260, 50+y1*4, 100, 30);
		// panel을 프레임에 부착
		add(p);
		setVisible(true);
	}
}