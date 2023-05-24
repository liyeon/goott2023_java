package com.tech.w02.mission;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class TypePanel extends JPanel implements ActionListener {

	protected JRadioButton hot, ice;
	protected ButtonGroup bg;
	protected String typeStr = "";

	public TypePanel() {
		setLayout(new GridLayout(3, 1));
		hot = new JRadioButton("HOT");
		
		JLabel ss = new JLabel("<html><body><center>s : 1500<br>m : 2000<br>L : 2500</center></body></html>");
		JLabel aa = new JLabel("<html><body><center>s : 2000<br>m : 2500<br>L : 3000</center></body></html>");
		ice = new JRadioButton("ICE");

		hot.addActionListener(this);
		ice.addActionListener(this);

		// border group 설정
		bg = new ButtonGroup();
		bg.add(hot);
		bg.add(ice);
		this.setBorder(BorderFactory.createTitledBorder("Type"));

		add(hot);
		add(ss);
		add(ice);
		add(aa);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == hot) {
			typeStr = "hot";
		} else if (e.getSource() == ice) {
			typeStr = "ice";
		} // if
		System.out.println("type 신호 " + typeStr);
	}// override
}// class TypePanel