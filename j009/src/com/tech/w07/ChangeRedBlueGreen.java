package com.tech.w07;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangeRedBlueGreen extends JFrame implements ActionListener {
	JPanel panel;
	JButton rButton, bButton, gButton, rgbButton;

	public static void main(String[] args) {
		new ChangeRedBlueGreen();
	}

	public ChangeRedBlueGreen() {
		setTitle("배경색");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		panel = new JPanel();
		rButton = new JButton("빨간색");
		bButton = new JButton("파란색");
		gButton = new JButton("초록색");
		rgbButton = new JButton("rgb");

		rButton.addActionListener(this);
		bButton.addActionListener(this);
		gButton.addActionListener(this);
		rgbButton.addActionListener(this);

		panel.add(rButton);
		panel.add(bButton);
		panel.add(gButton);
		panel.add(rgbButton);

		add(panel);

		setVisible(true);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==rButton) {
			panel.setBackground(Color.decode("#fa709a"));
		} else if (e.getSource()==bButton) {
			panel.setBackground(Color.decode("#66a6ff"));
		}else if (e.getSource()==gButton){
			panel.setBackground(Color.decode("#2af598"));
		}else if (e.getSource()==rgbButton) {
			panel.setBackground(new Color(24,184,162,100));
		}
	}// method
}// class