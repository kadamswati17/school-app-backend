package com.schoolapp.connection;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public void connectToDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		Statement st = (Statement) con.createStatement();
		System.out.println("Server start");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connect con = new Connect();
		con.connectToDB();
	}
}
