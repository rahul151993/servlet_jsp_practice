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
 * Servlet implementation class MyServlet2
 */
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(request.getParameter("name")+" you are able to login successfully");
		out.println("The Common application specific Data is as following");
		Enumeration<String> e1 = getServletConfig().getServletContext().getInitParameterNames();
		while(e1.hasMoreElements()) {
			String applicationSpecificKey = e1.nextElement();
			out.println("servletcontext key = "+applicationSpecificKey+" value = "+getServletConfig().getServletContext().getInitParameter(applicationSpecificKey));
		}
		out.println("the key = "+getServletConfig().getServletContext().getAttribute("delta"));
		request.getRequestDispatcher("/googlesearch.jsp").include(request,response);
	}

}
