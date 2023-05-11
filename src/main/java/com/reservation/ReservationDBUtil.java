package com.reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ReservationDBUtil {
	public static boolean insertreservation(String plocation,String dlocation,String pdate,String ddate,String ptime,String vtype,String uid) {
		
		boolean isSuccess= false;
		
		//create database connection
		String url = "jdbc:mysql://localhost:3306/rentalcars";
		String user = "root";
		String pass = "Pabasara123*";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "insert into reservation values(0,'"+plocation+"','"+dlocation+"','"+pdate+"','"+ddate+"','"+ptime+"','"+vtype+"','"+uid+"' )";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}
}
