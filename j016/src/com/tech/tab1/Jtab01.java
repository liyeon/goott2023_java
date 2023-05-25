package com.tech.tab1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Jtab01 extends JFrame implements ActionListener {

	JTabbedPane t = new JTabbedPane();
	JPanel p1 = new JPanel();
	JButton btn1 = new JButton("탭1");
	JButton btn2 = new JButton("탭2");
	JButton btn3 = new JButton("탭3");
	JTextField txt_1 = new JTextField("기본값",25);

	public Jtab01() {
		setTitle("use tab");
		setSize(450, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		p1.add(btn1);
		p1.add(btn2);
		p1.add(btn3);
		p1.add(txt_1);
		
		t.add("기록일지", new JTextArea());
		t.add("상태일지", p1);
		t.add("회원정보변경", new JTextArea());
		t.add("ABout", new JTextArea());
		
		
		
		add(t);
		setVisible(true);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("sign");
		if(e.getSource()==btn1) {
			t.setSelectedIndex(0);
		}else if(e.getSource()==btn2){
			t.setSelectedIndex(2);
		}else if(e.getSource()==btn3){
			t.setSelectedIndex(3);
		}//if
	}// override

	public static void main(String[] args) {
		new Jtab01();
	}// main

}// class