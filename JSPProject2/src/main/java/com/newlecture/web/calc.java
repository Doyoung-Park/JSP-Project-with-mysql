package com.newlecture.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/calc")

public class calc extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		ServletContext application=request.getServletContext();
		HttpSession session = request.getSession();
		
		Cookie[] cookies=request.getCookies();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();

		String v_=request.getParameter("v");
		String op=request.getParameter("operator");
		
		int v=0;
		if(!v_.equals("")) 
			v=Integer.parseInt(v_);
		
		if(op.equals("=")) {
		//	int x= (Integer)application.getAttribute("value");
		//	int x=(Integer)session.getAttribute("value");
			
			int x=0;
			int y=v;
			for(Cookie c: cookies) {
			
			if(c.getName().equals("value")) {	// 내가 원하는 쿠키를 찾았다면
				x=Integer.parseInt(c.getValue());
				break;
			 }
			}
			
			String operator="";
			 
			for(Cookie c: cookies)
				if(c.getName().equals("op")) {
					operator=c.getValue();
					break;
				}
			
			
			
		//	String operator=(String)application.getAttribute("op");
		//	String operator=(String)session.getAttribute("op");
			
			
			int result=0;
			if(operator.equals("+"))
				result=x+y;
			else if(operator.equals("-"))
				result=x-y;
			
			out.println("result : "+ result);
			
		}
		else {
	//		application.setAttribute("value",v);	// v 변수에 있는 것을 value 라는 이름으로
													// application 에 담겠다는 의미!
	//		application.setAttribute("op",op);		// op 변수에 있는 것을 op 라는 이름으로 
													// application 에 담겠다는 의미!
	//		session.setAttribute("value", v);
	//		session.setAttribute("op", op);
			
			// 쿠키 심음
			// 쿠키의 값으로 설정하는 것은 문자열로 저장해야 함
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op",op);
			valueCookie.setPath("/calc");
			opCookie.setPath("/calc");
			valueCookie.setMaxAge(24*60*60);
			
			
			// 만든 쿠키를 클라이언트에게 보냄 : response 헤더에 심어져서 전달이 됨
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc.html");
		}
	}
}
