package com.newlecture.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/add")

public class practice extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();

		int intX, intY,sum;
		String X=request.getParameter("X");
		String Y=request.getParameter("Y");
		intX=Integer.parseInt(X);
		intY=Integer.parseInt(Y);
		sum=intX+intY;
		
		out.println( sum +"<br/>");
		
		
	}
}
