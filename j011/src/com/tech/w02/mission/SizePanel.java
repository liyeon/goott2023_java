package com.tech.w02.mission;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class SizePanel extends JPanel implements ActionListener {
	protected JRadioButton small, medium, large;
	protected ButtonGroup bg;
	protected String sizeStr = "";

	public SizePanel() {
		setLayout(new GridLayout(3, 1));
		small = new JRadioButton("SMALL");
		medium = new JRadioButton("MEDIUM");
		large = new JRadioButton("LARGE");

		// 수신자 부착
		small.addActionListener(this);
		medium.addActionListener(this);
		large.addActionListener(this);

		// border group 설정
		bg = new ButtonGroup();
		bg.add(small);
		bg.add(medium);
		bg.add(large);
		this.setBorder(BorderFactory.createTitledBorder("SIZE"));

		add(small);
		add(medium);
		add(large);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == small) {
			sizeStr = "small";
		} else if (e.getSource() == medium) {
			sizeStr = "medium";
		} else if (e.getSource() == large) {
			sizeStr = "large";
		} // if
		System.out.println("size 신호 " + sizeStr);
	}// override

}// class SizePanel