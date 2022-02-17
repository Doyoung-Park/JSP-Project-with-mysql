package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/notice-reg")		// <-- 이렇게 하면 이 URL 주소를 책임지는 서블릿주소가 됨
public class NoticeReg extends HttpServlet{
	//request : 출력도구
	//response : 입력도구
	public void service(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
    	
    	response.setCharacterEncoding("UTF-8");	// UTF-8로 보내는 것
    	response.setContentType("text/html; charset=UTF-8");	
    	// 브라우저에게 
    	//'전달하는 파일이 html이다 
    	//UTF-8로 해석을 해라 라고 알려주는 것'     	
    	PrintWriter out=response.getWriter();	// 출력 도구
    	
    //	int cnt=Integer.parseInt(request.getParameter("cnt"));
    	// request.Parameter() : 사용자로부터 값을 입력받음 (문자열) -->정수형태로 바꿔주는 것이
    	// Integer.parseInt() 
    	
    	// request.setCharacterEncoding("UTF-8");	// 브라우저에서 읽어들일 때에도 UTF-8로 읽어라..!
    	
    	String title=request.getParameter("title");	// 임시변수에 받음	
    	String content=request.getParameter("content");	// 임시변수에 받음
    	
    	out.println(title);
    	out.println(content);
    	
    	   	
    } 
}
