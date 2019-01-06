package com.context.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener{
	
	public static Connection con = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			Statement st = con.createStatement();
			if(st.execute("DROP TABLE login")) {
				System.out.println("Dropped table successfully");
			}
			con.close();
			System.out.println("Connection is closed successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			System.out.println("Connection Successful");
			Statement st = con.createStatement();
			st.execute("create table login(id int auto_increment, name varchar(20) not null, password varchar(20) not null,primary key(id))");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
