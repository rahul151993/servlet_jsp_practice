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
 * Servlet implementation class LogOut
 */
//@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("LogOut");

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		if(session.getAttribute("userName")!=null) {			
			if(request.getServletContext().getAttribute("uN").equals(session.getAttribute("userName"))) {
				LOGGER.info("current user");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				session.invalidate();
			}
		}
		else
		{
			request.getRequestDispatcher("welcome.jsp").include(request,response);
			out.println("Please Log In First");
		}
	}
}
