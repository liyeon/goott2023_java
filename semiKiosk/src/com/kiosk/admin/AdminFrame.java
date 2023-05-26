package com.kiosk.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.kiosk.main.Favicon;
import com.kiosk.main.MainFrame;

public class AdminFrame extends JFrame {
	Font font = new Font("나눔바른고딕", Font.BOLD, 25);

	public AdminFrame() {

		setTitle("C A F E::Kiosk::Admin");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 900);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.decode("#7b00a0"));
		// 파비콘 설정
		setIconImage(Favicon.getFavi());

		// 패널
		JPanel l = new JPanel();
		l.setBackground(Color.decode("#7b00a0"));
		l.setPreferredSize(new Dimension(0, 300));
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#7b00a0"));

		JButton btn1 = new JButton("주문등록");
		btn1.setFont(font);
		btn1.setPreferredSize(new Dimension(250, 250));
		btn1.setBackground(Color.decode("#cdbadb"));
		btn1.setForeground(Color.white);
		btn1.setBackground(Color.decode("#7b00a0"));
		btn1.setBorder(new LineBorder(Color.white));
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
				dispose();
			}
		});

		JButton btn2 = new JButton("주문목록");
		btn2.setPreferredSize(new Dimension(250, 250));
		btn2.setFont(font);
		btn2.setForeground(Color.decode("#7b00a0"));
		btn2.setBackground(Color.white);
		btn2.setBorder(null);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminList();
				dispose();
			}
		});

		panel.add(btn1);
		panel.add(btn2);

		add(l, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setResizable(false);// 사이즈 조정 못하게
		setVisible(true);
	}// constructor
}// class