package com.tech.w05mission;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JobsViewer extends JFrame {
	// swing 으로 db 컨트롤
	JTextField id, title, min_salary, max_salary;
	JButton privButton, nextButton, insertButton, deleteButton, clearButton;

	ResultSet rs;
	Statement stmt;

	public JobsViewer() throws SQLException {
		Connection con = DBConnection.makeConnection();
		String sql = "select * from jobs2";
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);

		setTitle("디비컨트롤로로로로롤");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		JPanel labelPanel = new JPanel();
		JPanel fieldPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(0, 1));
		labelPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
		labelPanel.setBackground(Color.decode("#D0F5BE"));
		fieldPanel.setLayout(new GridLayout(0, 1));
		JLabel[] labels = new JLabel[4];
		labels[0] = new JLabel("ID");
		labels[1] = new JLabel("TITLE");
		labels[2] = new JLabel("최소 봉급");
		labels[3] = new JLabel("최대 봉급");

		for (int i = 0; i < labels.length; i++) {
			labelPanel.add(labels[i]);
			labels[i].setSize(new Dimension(200, 30));
			labels[i].setFont(new Font("나눔고딕", Font.BOLD, 15));
		}//for
		fieldPanel.setBackground(Color.decode("#D0F5BE"));
		fieldPanel.add(id = new JTextField());
		fieldPanel.add(title = new JTextField());
		fieldPanel.add(min_salary = new JTextField());
		fieldPanel.add(max_salary = new JTextField());

		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(0, 5));
		btnPanel.setBackground(Color.decode("#a5dff9"));
		privButton = new JButton("priv");
		privButton.setBorder(null);
		privButton.setBackground(Color.decode("#60c5ba"));
		privButton.setPreferredSize(new Dimension(0, 50));
		privButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("priv");
				try {
					rs.previous();
					id.setText(rs.getString("job_id"));
					title.setText(rs.getString("job_title"));
					min_salary.setText(rs.getString("min_salary"));
					max_salary.setText(rs.getString("max_salary"));
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
					id.setText(rs.getString("job_id"));
					title.setText(rs.getString("job_title"));
					min_salary.setText(rs.getString("min_salary"));
					max_salary.setText(rs.getString("max_salary"));
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
				String jid = id.getText();
				String jtitle = title.getText();
				int jmin = Integer.parseInt(min_salary.getText());
				int jmax = Integer.parseInt(max_salary.getText());
				String sql = "insert into jobs2 values('" + jid + "', '" + jtitle + "'," + jmin + "," + jmax + ")";
				try {
					stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					stmt.executeUpdate(sql);
					rs = stmt.executeQuery("select*from jobs2");
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
				String jid = id.getText();
				String sql = "delete from jobs2 WHERE job_id='" + jid + "'";
				try {
					stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					int cnt = stmt.executeUpdate(sql);
					System.out.println("삭제 갯수 : " + cnt);
					rs = stmt.executeQuery("select*from jobs2");
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
				id.setText("");
				title.setText("");
				min_salary.setText("");
				max_salary.setText("");
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
		new JobsViewer();
	}// main
}// class