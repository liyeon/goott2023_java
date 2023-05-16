package com.tech.w02;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

class ToppingPanel extends JPanel implements ActionListener {
	protected JCheckBox pepper, cheese, peperoni, bacon;
	protected ButtonGroup bg;
	protected String topStr = "";

	public ToppingPanel() {
		setLayout(new GridLayout(4, 1));
		pepper = new JCheckBox("피망");
		cheese = new JCheckBox("치이즈");
		peperoni = new JCheckBox("페페로니");
		bacon = new JCheckBox("베이컨");

		// 수신자 부착
		pepper.addActionListener(this);
		cheese.addActionListener(this);
		peperoni.addActionListener(this);
		bacon.addActionListener(this);

		// border group 설정
		bg = new ButtonGroup();
		bg.add(pepper);
		bg.add(cheese);
		bg.add(peperoni);
		bg.add(bacon);
		this.setBorder(BorderFactory.createTitledBorder("Topping"));

		add(pepper);
		add(cheese);
		add(peperoni);
		add(bacon);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pepper) {
			topStr = "pepper";
		} else if (e.getSource() == cheese) {
			topStr = "cheese";
		} else if (e.getSource() == peperoni) {
			topStr = "peperoni";
		} else if (e.getSource() == bacon) {
			topStr = "bacon";
		} // if
		System.out.println("topping2 신호 " + topStr);
	}// override
}// class ToppingPanel