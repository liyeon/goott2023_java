package com.tech.w03;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TempConvertExam extends JFrame {

	public static void main(String[] args) {
		// 온도변환기 화씨온도 섭씨온도 변환
		new TempConvertExam();
	}//

	public TempConvertExam() {
		setTitle("온도변환기");
		setSize(300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// panel 준비
		JPanel p = new JPanel();
		p.setLayout(null);

		// panel 색상 변경
		p.setBackground(Color.decode("#A0D8B3"));
		
		//label 준비
		JLabel label1 = new JLabel("화씨 온도");
		JLabel label2 = new JLabel("섭씨 온도");

		//textField 준비
		JTextField tf1 = new JTextField(15);
		JTextField tf2 = new JTextField(15);
		
		//버튼 준비
		JButton btn = new JButton("변환");


		p.add(label1);
		p.add(label2);

		p.add(tf1);
		p.add(tf2);

		p.add(btn);

		label1.setBounds(20, 50, 100, 30);
		label2.setBounds(20, 100, 100, 30);

		tf1.setBounds(100, 50, 150, 30);
		tf2.setBounds(100, 100, 150, 30);
		
		btn.setBackground(Color.decode("#F7E1AE"));
		btn.setBounds(90, 150, 100, 30);
		// panel을 프레임에 부착
		add(p);
		setVisible(true);
	}
}//