package com.tech.w02.mission;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

class WelcomePanel extends JPanel {
	private JLabel message;

	public WelcomePanel() {
		message = new JLabel("!!!!!LIYEON COFFEE SHOP!!!!!");
		this.add(message);// panel에 label 부착
	}// constructor
}// class WelcomePanel