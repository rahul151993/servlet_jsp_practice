package com.loginapp.auth.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthFilter implements Filter{

	private FilterConfig fc=null;
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		Connection con=null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			Statement st = con.createStatement();
			rs = st.executeQuery("select * from login");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = arg1.getWriter();
		boolean status = false;
		try {
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				if(rs.getString(2).equals(arg0.getParameter("userName")) && rs.getString(3).equals(arg0.getParameter("password"))) {
					System.out.println("successful login");
					status = true;
					break;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status==true) {
			arg2.doFilter(arg0, arg1);
		}
		else {
			out.println("Not Valid Person");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {		
		this.fc=arg0;
	}
}
