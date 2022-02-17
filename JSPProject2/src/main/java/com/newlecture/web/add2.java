package com.newlecture.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Vector;

@WebServlet("/add2")

public class add2 extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();

		String[] num_=request.getParameterValues("X");
		
		int sum=0;
		for(int i=0; i<num_.length; i++) {
			int num=Integer.parseInt(num_[i]);
			sum+=num;
		}
		
		out.println( sum +"<br/>");
		
		
	}
}
