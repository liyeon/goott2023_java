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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import com.kiosk.main.MainFrame;

public class LoginFrame extends JFrame implements FocusListener {
	Font font = new Font("나눔바른고딕", Font.BOLD, 17);
	JTextField id;
	JPasswordField pw;
	Connection conn = null;
	ResultSet rs;
	Statement stmt;

	public LoginFrame() {

		setTitle("C A F E::Kiosk::LOGIN");
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
		l.setPreferredSize(new Dimension(0, 300));
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

		JButton loginBtn = new JButton("로그인");
		loginBtn.setFont(font);
		loginBtn.setPreferredSize(new Dimension(350, 50));
		loginBtn.setBackground(Color.decode("#cdbadb"));
		loginBtn.setForeground(Color.white);
		loginBtn.setBackground(Color.decode("#7b00a0"));
		loginBtn.setBorder(new LineBorder(Color.white));

		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conn = DBConnection.makeConnection();
				String myId = id.getText();
				String myPwd = new String(pw.getPassword());
				String selectMemberSql = String.format("SELECT * FROM cafe_member WHERE id = '%s' AND pw='%s'", myId,
						myPwd);
				try {
					stmt = conn.createStatement();
					rs = stmt.executeQuery(selectMemberSql);
					rs.next();
					System.out.println(rs.getString(1));
					if (myId.equals(rs.getString(1)) && myPwd.equals(rs.getString(2))) {
						JOptionPane.showMessageDialog(null, "로그인되었습니다.");
						rs.close();
						new AdminFrame();
						dispose();
					} else {
						System.out.println("로그인실패");
						rs.close();
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "로그인 실패\n다시 입력해주세요");
//					e1.printStackTrace();
				}
			}// method override
		});

		JButton joinBtn = new JButton("회원가입");
		joinBtn.setPreferredSize(new Dimension(350, 50));
		joinBtn.setFont(font);
		joinBtn.setForeground(Color.decode("#7b00a0"));
		joinBtn.setBackground(Color.white);
		joinBtn.setBorder(null);

		joinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new JoinFrame();
				dispose();
			}
		});

		login.add(id);
		login.add(pw);
		login.add(loginBtn);
		login.add(joinBtn);

		add(l, BorderLayout.NORTH);
		add(login, BorderLayout.CENTER);
		setResizable(false);// 사이즈 조정 못하게
		setVisible(true);
	}// constructor

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == id) {
			id.setText("");
		} else if (e.getSource() == pw) {
			pw.setText("");
		}
	}// focusListener

	@Override
	public void focusLost(FocusEvent e) {}
}// class