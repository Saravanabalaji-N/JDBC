package com.chainsys.connection;

import java.sql.*;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args) throws SQLException {

		read();
		update();
		delete();
	}

	public static void read() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/Login1";
		String userName = "root";
		String password = "Saravana#026";
		String query = "select * from check1";

		Connection connection = DriverManager.getConnection(url, userName, password);

		PreparedStatement prs = connection.prepareStatement(query);
		ResultSet rs = prs.executeQuery(query);

		while (rs.next()) {
			System.out.print(rs.getString(1) + "\t");
			System.out.println(rs.getString(2) + "\t");
//			System.out.println(rs.getInt(3));
		}
		connection.close();

	}

	public static void update() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/Login1";
		String userName = "root";
		String password = "Saravana#026";
		Connection connection = DriverManager.getConnection(url, userName, password);

		Scanner sc = new Scanner(System.in);
		String userName1;
		String password1;
		String pattern = "[a-zA-Z0-9]{1,12}";
		String pattern2 = "[a-zA-Z0-9]{1,12}";
//		int salary;

		System.out.println("\n   -----LOGIN-----\n");
		System.out.println("enter your UserName :");
		userName1 = sc.next();
		while (!userName1.matches(pattern)) {
			System.err.println("Incorrect UserName");
			System.out.println("enter your UserName again:");
			userName1 = sc.next();
//			s=true;
		}
		System.out.println("enter your Password :");
		password1 = sc.next();
		while (!password1.matches(pattern2)) {
			System.err.println("Incorrect Password");
			System.out.println("enter your Password again:");
			password1 = sc.next();
//			s=true;
		}
//		System.out.println("enter salary :");
//		salary = sc.nextInt();

		String query = "insert into check1 values(?,?);";
		PreparedStatement prs = connection.prepareStatement(query);

		prs.setString(1, userName1);
		prs.setString(2, password1);
//		prs.setInt(3, salary);
		int rows = prs.executeUpdate();
		System.out.println("rows affected :" + rows);

		connection.close();

	}

	public static void delete() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/Login1";
		String userName = "root";
		String password = "Saravana#026";

		Scanner sc = new Scanner(System.in);

		String id;
	

		System.out.println("enter id :");
		id = sc.next();	

		String query = "delete from check1 where userName=?;";
		Connection connection = DriverManager.getConnection(url, userName, password);

		PreparedStatement prs = connection.prepareStatement(query);

		prs.setString(1, id);
		int rows = prs.executeUpdate();
		System.out.println("rows affected :" + rows);

		connection.close();

	}

}
