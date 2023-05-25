package com.tech.tab2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ViewA extends JPanel {
	JButton btn1, btn2, btn3;
	JComboBox cbox;
	JTextArea ta;

	public ViewA() {
		setLayout(new BorderLayout());
		setBackground(Color.yellow);
		btn1 = new JButton("btn1");
		btn2 = new JButton("btn2");
		btn3 = new JButton("btn3");
		JPanel p1 = new JPanel();
		p1.add(btn1);
		p1.add(btn2);
		p1.add(btn3);

		JPanel p2 = new JPanel();
		String[] fruites = { "apple1", "apple2", "apple3" };
		cbox = new JComboBox(fruites);
		p2.add(cbox);
		p2.setLayout(new GridLayout(0, 1));
		p2.add(ta = new JTextArea());

		add(p1, "North");
		add(p2, "Center");
	}// constructor

}// class