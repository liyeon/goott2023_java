package com.tech.w02.mission;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

class SidePanel extends JPanel implements ActionListener {
	protected JCheckBox cookie, banana, sandwich, chocolate;
	protected ButtonGroup bg;
	protected String topStr = "";

	public SidePanel() {
		setLayout(new GridLayout(4, 1));
		cookie = new JCheckBox("쿠키 2000원");
		banana = new JCheckBox("바나나 3000원");
		sandwich = new JCheckBox("샌드위치 5000원");
		chocolate = new JCheckBox("초콜렛 4000원");

		// 수신자 부착
		cookie.addActionListener(this);
		banana.addActionListener(this);
		sandwich.addActionListener(this);
		chocolate.addActionListener(this);

		// border group 설정
		bg = new ButtonGroup();
		bg.add(cookie);
		bg.add(banana);
		bg.add(sandwich);
		bg.add(chocolate);
		this.setBorder(BorderFactory.createTitledBorder("SIDE"));

		add(cookie);
		add(banana);
		add(sandwich);
		add(chocolate);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cookie) {
			topStr = "cookie";
		} else if (e.getSource() == banana) {
			topStr = "banana";
		} else if (e.getSource() == sandwich) {
			topStr = "sandwich";
		} else if (e.getSource() == chocolate) {
			topStr = "chocolate";
		} // if
		System.out.println("topping2 신호 " + topStr);
	}// override
}// class ToppingPanel