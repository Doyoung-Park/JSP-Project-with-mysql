package com.newlecture.web;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/calc3")

public class calc3 extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
	
		Cookie[] cookies=request.getCookies();
		
		String value=request.getParameter("value");
		String operator=request.getParameter("operator");
		String dot=request.getParameter("dot");
		
		String exp="";
		
		if(cookies !=null) 
			for(Cookie c: cookies)
				if(c.getName().equals("exp")) {
					exp=c.getValue();
					break;
				}
		
		if(operator !=null && operator.equals("=")) {
			ScriptEngine engine=new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(operator !=null && operator.equals("C")) {
		//계산기에서 C버튼을 누르면 캐시가 삭제됨.
			exp="";
		}
		
		else {
		exp+=(value==null)?"":value;
		exp+=(operator==null)?"":operator;
		exp+=(dot==null)?"":dot;
		}
		Cookie expCookie = new Cookie("exp",exp);
		
		if(operator !=null && operator.equals("C"))
			expCookie.setMaxAge(0);
		
		response.addCookie(expCookie);
		
		response.sendRedirect("CalcPage");
		
	}
}
