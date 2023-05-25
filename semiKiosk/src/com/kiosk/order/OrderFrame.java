package com.kiosk.order;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.kiosk.page.KioskPage;

public class OrderFrame extends JFrame {
	KioskPage kioskPage;

	public OrderFrame() {

	}// constructors

	public OrderFrame(KioskPage kioskPage) {
		this.kioskPage=kioskPage;
		setTitle("C A F E::Kiosk");
		setLayout(new BorderLayout());
		setSize(600, 900);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		getContentPane().setBackground(Color.white);
		System.out.println(kioskPage.list.getSelectedValuesList());
		JLabel label = new JLabel("asda");
		add(label);
		setVisible(true);
	}

	public static void main(String[] args) {
		new OrderFrame();
	}// main

}// class