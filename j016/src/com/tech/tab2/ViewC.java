package com.tech.tab2;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewC extends JPanel {
	JButton btn1, btn2, btn3;
	JTextField fieldc;

	public ViewC() {
		setBackground(new Color(100, 100, 100));
		btn1 = new JButton("btn1");
		btn2 = new JButton("btn2");
		btn3 = new JButton("btn3");

		fieldc = new JTextField(30);
		add(btn1);
		add(btn2);
		add(btn3);
		add(fieldc);
	}// constructor
}// class