package com.tech.mission;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SendNum3 extends JFrame implements ActionListener {
	private JButton btn1, btn2, btn3, btn4, btnPlus, btnEqual;
	private int num1, num2;
	private JTextField tf;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			tf.setText(tf.getText()+e.getActionCommand());
		}else if(e.getSource()==btn2) {
			tf.setText(tf.getText()+e.getActionCommand());
		}else if(e.getSource()==btn3) {
			tf.setText(tf.getText()+e.getActionCommand());
		}else if(e.getSource()==btnPlus){
			this.num1=Integer.parseInt(tf.getText());
			tf.setText("");
		}else if(e.getSource()==btnEqual) {
			this.num2=Integer.parseInt(tf.getText());
			System.out.println("num1 : "+num1);
			System.out.println("num2 : "+num2);
			int sum = num1+num2;
			tf.setText("합계 : "+sum);
		}else {
			tf.setText("");
		}//if
	}//method

	public SendNum3() {
		setTitle("번호 떤져!");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		btn1=new JButton("1");
		btn2=new JButton("2");
		btn3=new JButton("3");
		btnPlus=new JButton("+");
		btnEqual=new JButton("=");
		btn4=new JButton("reset");
		
		//버튼들에 수신자 부착
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btnPlus.addActionListener(this);
		btnEqual.addActionListener(this);
		
		//panel 그리드 레이아웃으로 변경
		panel.setLayout(new GridLayout(0,5,3,3));
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btnPlus);
		panel.add(btnEqual);
		
		//textfield 생성
		tf = new JTextField(15);
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.setPreferredSize(new Dimension(0,50));
		tf.setBackground(Color.decode("#BA90C6"));
		tf.setFont(new Font("나눔고딕", Font.BOLD, 15));
		tf.setForeground(Color.white);
		
		
		add(tf,"North");
		add(panel, "Center");
		add(btn4, "South");
		
		setVisible(true);
	}//constructor
	
	public static void main(String[] args) {
		new SendNum3();
	}//main
}//class