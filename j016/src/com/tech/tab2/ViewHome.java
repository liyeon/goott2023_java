package com.tech.tab2;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ViewHome extends JPanel {
	JButton btnHome;

	public ViewHome() {
		setBackground(Color.pink);
		btnHome=new JButton("btnhome");
		add(btnHome);
	}// constructor
}// class