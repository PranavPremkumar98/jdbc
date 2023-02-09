package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bike {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/javadesk";
		String username= "root";
		String password= "root";
//        String sql = "INSERT INTO bikes VALUES(4,'yamaha','rz',120000)";
//		String sql = "UPDATE bikes SET name ='xyz' WHERE id=2 ";
		String sql = "SELECT * FROM bikes";
        Connection connection = null;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
		ResultSet resultset =	statement.executeQuery(sql);
		while(resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getString(3));
			System.out.println("==========================================");
		}
			System.out.println("all done");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally {
        	connection.close();
        }
	}
	
	

}
