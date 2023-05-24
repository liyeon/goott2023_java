package com.tech.w05mission;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class StudentViwer extends JFrame {
	// swing 으로 db 컨트롤
	JTextField no, name, addr, grade, birth, subj, score;
	JButton privButton, nextButton, insertButton, deleteButton, clearButton;

	ResultSet rs;
	Statement stmt;

	public StudentViwer() throws SQLException {
		Connection con = DBConnection.makeConnection();
		String sql = "select * from studentinfo";
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);

		setTitle("디비컨트롤로로로로롤");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JPanel labelPanel = new JPanel();
		JPanel fieldPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(0, 1));
		labelPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
		labelPanel.setBackground(Color.decode("#a5dff9"));
		fieldPanel.setLayout(new GridLayout(0, 1));
		JLabel[] labels = new JLabel[7];
		labels[0] = new JLabel("no");
		labels[1] = new JLabel("name");
		labels[2] = new JLabel("addr");
		labels[3] = new JLabel("grade");
		labels[4] = new JLabel("birth");
		labels[5] = new JLabel("subj");
		labels[6] = new JLabel("score");

		for (int i = 0; i < labels.length; i++) {
			labelPanel.add(labels[i]);
			labels[i].setSize(new Dimension(200, 30));
			labels[i].setFont(new Font("나눔고딕", Font.BOLD, 15));
		}
		fieldPanel.setBackground(Color.decode("#a5dff9"));
		fieldPanel.add(no = new JTextField());
		fieldPanel.add(name = new JTextField());
		fieldPanel.add(addr = new JTextField());
		fieldPanel.add(grade = new JTextField());
		fieldPanel.add(birth = new JTextField());
		fieldPanel.add(subj = new JTextField());
		fieldPanel.add(score = new JTextField());

		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(0, 5));
		btnPanel.setBackground(Color.decode("#a5dff9"));
		privButton = new JButton("priv");
		privButton.setBorder(null);
		privButton.setBackground(Color.decode("#60c5ba"));
		privButton.setPreferredSize(new Dimension(0,50));
		privButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("priv");
				try {
					rs.previous();
					no.setText(rs.getString("s_no"));
					name.setText(rs.getString("s_name"));
					addr.setText(rs.getString("s_addr"));
					grade.setText(rs.getString("s_grade"));
					birth.setText(rs.getString("s_birth"));
					subj.setText(rs.getString("s_subj"));
					score.setText(rs.getString("s_score"));
				} catch (SQLException e1) {
					System.out.println("자료없음");
//					e1.printStackTrace();
				} // try~catch
			}// method
		});// privButton
		nextButton = new JButton("next");
		nextButton.setBackground(Color.decode("#a5d296"));
		nextButton.setBorder(null);
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("next");
				try {
					rs.next();
					no.setText(rs.getString("s_no"));
					name.setText(rs.getString("s_name"));
					addr.setText(rs.getString("s_addr"));
					grade.setText(rs.getString("s_grade"));
					birth.setText(rs.getString("s_birth"));
					subj.setText(rs.getString("s_subj"));
					score.setText(rs.getString("s_score"));
				} catch (SQLException e1) {
					System.out.println("자료없음");
//					e1.printStackTrace();
				} // try~catch
			}// method
		});//
		insertButton = new JButton("insert");
		insertButton.setBackground(Color.decode("#f2e9e1"));
		insertButton.setBorder(null);
		insertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("insert");
				int sno = Integer.parseInt(no.getText());
				String sname = name.getText();
				String saddr = addr.getText();
				int sgrade = Integer.parseInt(grade.getText());
				String sbirth = birth.getText();
				String ssubj = subj.getText();
				int sscore = Integer.parseInt(score.getText());
				String sql = "insert into studentinfo values('+" + sno + "', '" + sname + "', '" + saddr + "', '"
						+ sgrade + "', '" + sbirth + "', '" + ssubj + "', '" + sscore + "')";
				try {
					stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					stmt.executeUpdate(sql);
					rs = stmt.executeQuery("select*from studentinfo");
				} catch (SQLException e1) {
					e1.printStackTrace();
				} // try~catch
			}// actionPerformed
		});// insertButton
		deleteButton = new JButton("delete");
		deleteButton.setBackground(Color.decode("#f8ecc9"));
		deleteButton.setBorder(null);
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("delete");
				String sno = no.getText();
				String sql = "delete from studentinfo WHERE s_no='" + sno + "'";
				try {
					stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					int cnt = stmt.executeUpdate(sql);
					System.out.println("삭제 갯수 : " + cnt);
					rs = stmt.executeQuery("select*from studentinfo");
				} catch (SQLException e1) {
					e1.printStackTrace();
				} // try~catch
			}// method
		});// deleteButton
		clearButton = new JButton("clear");
		clearButton.setBackground(Color.decode("#f9cdad"));
		clearButton.setBorder(null);
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clear");
				no.setText("");
				name.setText("");
				addr.setText("");
				grade.setText("");
				birth.setText("");
				subj.setText("");
				score.setText("");
			}// method
		});// clearButton

		btnPanel.add(privButton);
		btnPanel.add(nextButton);
		btnPanel.add(insertButton);
		btnPanel.add(deleteButton);
		btnPanel.add(clearButton);
		add(labelPanel, "West");
		add(fieldPanel, "Center");
		add(btnPanel, "South");
		setVisible(true);
	}// constructor

	public static void main(String[] args) throws SQLException {
		new StudentViwer();
	}// main
}// class