package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class PracticeMember extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out= response.getWriter();
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String hobby=request.getParameter("hobby");
		String gender=request.getParameter("gender");
		
		String religion=request.getParameter("religion");
		String introduction=request.getParameter("introduction");
		
		
		
		out.println("Your ID is:"+id+"<br/>");
		out.println("Your pwd is:"+pwd+"<br/>");
		out.println("Your hobby is:"+hobby+"<br/>");
		out.println("Your gender is:"+gender+"<br/>");
		out.println("Your religion is:"+religion+"<br/>");
		out.println("Your introduction is:"+introduction+"<br/>");

		
		
	}
			

}
