package com.login.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogIn
 */
//@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("LogIn");
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("I am in Do Get");
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		if(("admin").equals(userName) && ("admin123").equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("userName", userName);
			session.setAttribute("password", password);
			req.getServletContext().setAttribute("uN",userName);
			req.getRequestDispatcher("welcome.jsp").include(req, resp);
			out.println("UserName = "+session.getAttribute("userName"));
		}
		else
		{
			out.println("This is not valid credentials please try once again");
			req.getRequestDispatcher("login.jsp").include(req, resp);
		}
	}

}
