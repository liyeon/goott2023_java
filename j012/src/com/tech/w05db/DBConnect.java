package com.tech.w05db;

import java.sql.DriverManager;

public class DBConnect {
	// 자바에서 오라클 접속
	public static void main(String[] args) {
		// db 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pass = "123456";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.getConnection(url, user, pass);
			System.out.println("====== DB 접속 성공 ======");
		} catch (Exception e) {
			// ocjdbc6.jar drive를 적재하지 않았다면
			System.out.println("디비연결실패");
			e.printStackTrace();
		} // try~catch

	}// main
}// class