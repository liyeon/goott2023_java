package com.tech.w05mission;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudentViewer extends JFrame {
//   학생뷰어미션
	// swing 으로 db컨트롤
	JTextField no, name, addr, grade, birth, subj, score;
	JButton privButton, nextButton, insertButton, deleteButton, clearButton;
	ResultSet rs;
	Statement stmt;

	public StudentViewer() throws SQLException {
		Connection con = makeConnection();
		String sql = "select * from studentinfo";
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);

		// 350 200
		setTitle("디비뷰어");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 300);
		setLayout(new GridLayout(0, 2));
		add(new JLabel("No"));
		add(no = new JTextField());
		add(new JLabel("Name"));
		add(name = new JTextField());
		add(new JLabel("Addr"));
		add(addr = new JTextField());
		add(new JLabel("Grade"));
		add(grade = new JTextField());
		add(new JLabel("Birth"));
		add(birth = new JTextField());
		add(new JLabel("Subj"));
		add(subj = new JTextField());
		add(new JLabel("Score"));
		add(score = new JTextField());

		privButton = new JButton("priv");
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
					birth.setText("" + rs.getInt("s_birth"));
					subj.setText("" + rs.getInt("s_subj"));
					score.setText("" + rs.getInt("s_score"));

				} catch (SQLException e1) {
					System.out.println("자료없음priv");
				}

			}
		});
		nextButton = new JButton("next");
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
					birth.setText("" + rs.getInt("s_birth"));
					subj.setText("" + rs.getInt("s_subj"));
					score.setText("" + rs.getInt("s_score"));

				} catch (SQLException e1) {
					System.out.println("자료없음");
				}

			}
		});

		insertButton = new JButton("insert");
		insertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("insert");
				String eno = no.getText();
				String ename = name.getText();
				String eaddr = addr.getText();
				int egrade = Integer.parseInt(grade.getText());
				String ebirth = birth.getText();
				String esubj = subj.getText();
				int escore = Integer.parseInt(score.getText());
				String sql = "insert into studentinfo values(" + "" + eno + ",'" + ename + "','" + eaddr + "'," + egrade
						+ ",'" + ebirth + "','" + esubj + "'," + escore + ")";
				try {
					stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					stmt.executeUpdate(sql);// 실행
					rs = stmt.executeQuery("select * from studentinfo");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		deleteButton = new JButton("delete");
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("insert");
				int eno = Integer.parseInt(no.getText());
				String sql = "delete from studentinfo where s_no=" + eno + "";
				try {
					stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					int cnt = stmt.executeUpdate(sql);// 실행
					System.out.println("삭제갯수:" + cnt);
					rs = stmt.executeQuery("select * from studentinfo");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		clearButton = new JButton("clear");
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

			}
		});

		add(privButton);
		add(nextButton);
		add(insertButton);
		add(deleteButton);
		add(clearButton);

		setVisible(true);

	}

	private Connection makeConnection() {
		// Db접속메소드
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pass = "123456";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pass);
			System.out.println("연결성공");

		} catch (Exception e) {
			System.out.println("연결실패");
		}
		return con;
	}

	public static void main(String[] args) throws SQLException {
		new StudentViewer();
	}

}