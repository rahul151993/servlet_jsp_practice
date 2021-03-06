package com.servlet.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String uName = request.getParameter("name");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		Enumeration<String> e = getServletConfig().getInitParameterNames();
		while(e.hasMoreElements()) {
			String key  = e.nextElement();
			out.println("The name is = "+key);
			out.println("The Valus is  = "+getServletConfig().getInitParameter(key));
		}
		out.println("The Common application specific Data is as following");
		Enumeration<String> e1 = getServletConfig().getServletContext().getInitParameterNames();
		while(e1.hasMoreElements()) {
			String applicationSpecificKey = e1.nextElement();
			out.println("servletcontext key = "+applicationSpecificKey+" value = "+getServletConfig().getServletContext().getInitParameter(applicationSpecificKey));
		}
		getServletConfig().getServletContext().setAttribute("delta", "charlie");
		if(password.equals("rahul")) {
			request.getRequestDispatcher("./MS2").forward(request, response);
		}
		else {
			out.println("<div>");
			out.println("<p>"+"Wrong Password"+"</p>");
			out.println("</div>");
			request.getRequestDispatcher("/index.jsp").include(request, response);
		}
	}
}
