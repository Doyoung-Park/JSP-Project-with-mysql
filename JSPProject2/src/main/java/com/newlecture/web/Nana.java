 package com.newlecture.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/hi")
public class Nana extends HttpServlet{
	//request : 출력도구
	//response : 입력도구
	public void service(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
    	
    	response.setCharacterEncoding("UTF-8");	// UTF-8로 보내는 것
    	response.setContentType("text/html; charset=UTF-8");	
    	// 브라우저에게 
    	//'전달하는 파일이 html이다 
    	//UTF-8로 해석을 해라 라고 알려주는 것'     	
    	PrintWriter out=response.getWriter();
    	
    //	int cnt=Integer.parseInt(request.getParameter("cnt"));
    	// request.Parameter() : 사용자로부터 값을 입력받음 (문자열) -->정수형태로 바꿔주는 것이
    	// Integer.parseInt() 
    	String cnt_=request.getParameter("cnt");	// 임시변수에 받음
    	int cnt=100;		// 기본값
    		
    	if(cnt_!=null && !cnt_.equals(""))
    		cnt=Integer.parseInt(cnt_);
    	
    	for(int i=0; i<cnt; i++) 
    		out.println((i+1)+" 안녕!! hello<br/>");
    	
    } 
}
