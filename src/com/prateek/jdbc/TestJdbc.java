package com.prateek.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String username = "root";
		String password = "prateek@123";

		try {
			System.out.println("Connecting to MySql Database" + jdbcUrl);

			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			connection.close();

			System.out.println("Connection Successful");

		} catch (Exception exception) {

		}
	}

}
