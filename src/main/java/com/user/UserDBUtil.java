package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDBUtil {
	
	public static List<User> validate(String userName,String password){
		
		ArrayList<User> use = new ArrayList<>();
		
		//create database connection
		String url = "jdbc:mysql://localhost:3306/rentalcars";
		String user = "root";
		String pass = "Pabasara123*";
		
		//validate
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();			
			String sql = "select * from user where username = '"+userName+"' and password = '"+password+"'"; 			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				
				//session.setAttribute("name",rs.getString("username"));
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String userU = rs.getString(5);
				String passU = rs.getString(6);
				
				User u = new User(id,name,email,phone,userU,passU);
				use.add(u);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return use;

	}
	
}
