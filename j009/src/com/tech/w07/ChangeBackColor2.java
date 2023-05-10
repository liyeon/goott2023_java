package com.tech.w07;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangeBackColor2 extends JFrame implements ActionListener{
	JPanel panel;
	JButton yButton, pButton;
	public static void main(String[] args) {
		new ChangeBackColor2();
	}
	public ChangeBackColor2() {
		setTitle("배경색");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		panel= new JPanel();
		yButton = new JButton("노랑");
		pButton = new JButton("핑크");
		
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
		if(e.getSource()==yButton) {
			panel.setBackground(Color.YELLOW);
		}else if(e.getSource()==pButton) {
			panel.setBackground(Color.PINK);
		}
	}//method 
}//class