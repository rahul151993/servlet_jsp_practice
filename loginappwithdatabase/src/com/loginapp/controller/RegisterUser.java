package com.loginapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginapp.model.User;
import com.loginapp.service.RegisterUserService;
import com.loginapp.serviceimpl.RegistrationUserServiceImpl;

/**
 * Servlet implementation class RegisterUser
 */
//@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("registration.jsp").include(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		System.out.println("user name = "+userName+" password = "+password+" for registration");
		User user = new User();
		user.setuId(0);
		user.setUserName(userName);
		user.setPassword(password);
		RegisterUserService regService = new RegistrationUserServiceImpl();
		boolean status =regService.addUser(user);
		PrintWriter out = resp.getWriter();
		if(status) {
			out.println("user added successfully");
		}else
		{
			out.println("not added");
		}
	}
}
