package com.tech.tab2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ViewD extends JPanel {
	JButton btn1, btn2, btn3;
	JComboBox cbox;
	JTextArea ta;

	public ViewD() {
		setLayout(new BorderLayout());
		setBackground(Color.orange);
		btn1 = new JButton("btn1");
		btn2 = new JButton("btn2");
		btn3 = new JButton("btn3");
		JPanel p1 = new JPanel();
		p1.add(btn1);
		p1.add(btn2);
		p1.add(btn3);

		JPanel p2 = new JPanel();
		String[] fruites2 = { "banana1", "banana2", "banana3" };
		cbox = new JComboBox(fruites2);
		p2.add(cbox);
		p2.setLayout(new GridLayout(0, 1));
		p2.add(ta = new JTextArea());

		add(p1, "North");
		add(p2, "Center");
	}// constructor

}// class