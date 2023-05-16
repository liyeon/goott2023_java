package com.tech.w02;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class TypePanel extends JPanel implements ActionListener {

	protected JRadioButton combo, potato, bulgogi;
	protected ButtonGroup bg;
	protected String typeStr = "";

	public TypePanel() {
		setLayout(new GridLayout(3, 1));
		combo = new JRadioButton("콤보");
		potato = new JRadioButton("감자");
		bulgogi = new JRadioButton("불고기");

		combo.addActionListener(this);
		potato.addActionListener(this);
		bulgogi.addActionListener(this);

		// border group 설정
		bg = new ButtonGroup();
		bg.add(combo);
		bg.add(potato);
		bg.add(bulgogi);
		this.setBorder(BorderFactory.createTitledBorder("Type"));

		add(combo);
		add(potato);
		add(bulgogi);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == combo) {
			typeStr = "combo";
		} else if (e.getSource() == potato) {
			typeStr = "potato";
		} else if (e.getSource() == bulgogi) {
			typeStr = "bulgogi";
		} // if
		System.out.println("type2 신호 " + typeStr);
	}// override
}// class TypePanel