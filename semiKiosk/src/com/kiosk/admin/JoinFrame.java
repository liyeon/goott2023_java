package com.kiosk.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.db.DBConnection;
import com.kiosk.main.Favicon;

public class JoinFrame extends JFrame implements FocusListener {
	Connection conn = null;
	Font font = new Font("나눔바른고딕", Font.BOLD, 17);
	JTextField id, name;
	JPasswordField pw;

	public JoinFrame() {
		setTitle("C A F E::Kiosk::JOIN");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 900);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.decode("#7b00a0"));
		// 파비콘 설정
		setIconImage(Favicon.getFavi());
		// 패널
		JPanel l = new JPanel();
		l.setBackground(Color.decode("#7b00a0"));
		l.setPreferredSize(new Dimension(0, 280));
		JPanel login = new JPanel();
		login.setBackground(Color.decode("#7b00a0"));
		id = new JTextField(30);
		id.setPreferredSize(new Dimension(400, 50));
		id.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		id.addFocusListener(this);
		id.setText("아이디");

		pw = new JPasswordField(30);
		pw.setPreferredSize(new Dimension(400, 50));
		pw.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pw.setText("비밀번호");
		pw.addFocusListener(this);

		name = new JTextField(30);
		name.setPreferredSize(new Dimension(400, 50));
		name.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		name.setText("이름");
		name.addFocusListener(this);

		JButton joinBtn = new JButton("회원가입");
		joinBtn.setFont(font);
		joinBtn.setPreferredSize(new Dimension(350, 50));
		joinBtn.setBackground(Color.decode("#cdbadb"));
		joinBtn.setForeground(Color.white);
		joinBtn.setBackground(Color.decode("#7b00a0"));
		joinBtn.setBorder(new LineBorder(Color.white));

		joinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("조인");
				String myId = id.getText();
				String myPwd = new String(pw.getPassword());
				String myName = name.getText();
				conn = DBConnection.makeConnection();
				String insertMemberSql = "insert into cafe_member values('" + myId + "','" + myPwd + "','" + myName
						+ "')";
				try {
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(insertMemberSql);
					JOptionPane.showMessageDialog(null, "아이디 : " + myId + "\n이름 : " + myName, "가입완료",
							JOptionPane.PLAIN_MESSAGE);
					JOptionPane.showMessageDialog(null, "가입완료");
					new LoginFrame();
					dispose();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "가입실패\n중복된 아이디가 있습니다.");
//					e1.printStackTrace();
				} // try~catch
			}
		});

		JButton cancelBtn = new JButton("취소");
		cancelBtn.setPreferredSize(new Dimension(350, 50));
		cancelBtn.setFont(font);
		cancelBtn.setForeground(Color.decode("#7b00a0"));
		cancelBtn.setBackground(Color.white);
		cancelBtn.setBorder(null);

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginFrame();
				dispose();
			}
		});

		login.add(id);
		login.add(pw);
		login.add(name);
		login.add(joinBtn);
		login.add(cancelBtn);

		add(l, BorderLayout.NORTH);
		add(login, BorderLayout.CENTER);
		setResizable(false);// 사이즈 조정 못하게
		setVisible(true);
		setVisible(true);

	}// constructor
	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {

	}

}// class