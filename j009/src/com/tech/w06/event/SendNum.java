package com.tech.w06.event;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SendNum extends JFrame implements ActionListener {
	private JButton btn1, btn2, btn3, btn4;
	private JTextField tf;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String num=e.getActionCommand();// 버튼의 label 출력
		if(num.equals("1")) {
			tf.setText(tf.getText()+num);
		}else if(num.equals("2")) {
			tf.setText(tf.getText()+num);
		}else if(num.equals("3")) {
			tf.setText(tf.getText()+num);
		}else {
			tf.setText("");
		}
	}//method

	public SendNum() {
		setTitle("번호 떤져!");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		btn1=new JButton("1");
		btn2=new JButton("2");
		btn3=new JButton("3");
		btn4=new JButton("reset");
		
		//버튼들에 수신자 부착
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		
		//panel 그리드 레이아웃으로 변경
		panel.setLayout(new GridLayout(0,3,3,3));
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		
		//textfield 생성
		tf = new JTextField(15);
		tf.setHorizontalAlignment(JTextField.CENTER);
		
		//프레임에 부탁
		add(tf,"North");
		add(panel, "Center");
		add(btn4, "South");
		
		setVisible(true);
	}//constructor
	
	public static void main(String[] args) {
		new SendNum();
	}//main

}//class