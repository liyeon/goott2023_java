package com.tech.w01;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageLabelExam2 extends JFrame implements ActionListener {
	private JPanel panel;
	private JLabel label;
	private JButton button;

	public ImageLabelExam2() {
		setTitle("이미지컨트로롤");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		panel = new JPanel();
		label = new JLabel("이미지를 보려면 버튼을 클릭하세요");
		button = new JButton("이미지버튼");

		ImageIcon icon = new ImageIcon("src/icon.png");
		button.setIcon(icon);
		button.setPreferredSize(new Dimension(200, 50));
		button.addActionListener(this);
		panel.add(button);
		panel.add(label);

		add(panel);
		setVisible(true);
	}// constructor

	private boolean flag=true;
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("신호신호");
		
		if(flag) {
			ImageIcon dog = new ImageIcon("src/dog.gif");
			label.setIcon(dog);
			label.setText("");
			flag = false;
		}else {
			label.setIcon(null);
			label.setText("이미지를 보려면 버튼을 클릭하세요");
			flag = true;
		}
	}// method overriding

	public static void main(String[] args) {
		new ImageLabelExam2();
	}// main
}// class