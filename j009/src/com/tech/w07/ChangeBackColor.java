package com.tech.w07;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangeBackColor extends JFrame implements ActionListener{
	JPanel panel;
	public static void main(String[] args) {
		new ChangeBackColor();
	}
	public ChangeBackColor() {
		setTitle("배경색");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		panel= new JPanel();
		JButton yButton = new JButton("노랑");
		JButton pButton = new JButton("핑크");
		
		yButton.addActionListener(this);
		pButton.addActionListener(this);
		
		panel.add(yButton);
		panel.add(pButton);
		
		
		panel.setBackground(Color.ORANGE);
		add(panel);
		
		setVisible(true);
	}//constructor
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("노랑")) {
			panel.setBackground(Color.YELLOW);
		}else if(e.getActionCommand().equals("핑크")) {
			panel.setBackground(Color.PINK);
		}
	}//method 
}//class