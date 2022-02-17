package com.newlecture.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));

		String url="jdbc:mysql://localhost:3306/newlecture";
		String sql = "SELECT * FROM NOTICE WHERE ID=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(url,"doyoung","Tlswm7923!@");

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			rs.next();

			String title= rs.getString("TITLE");
			 String writerID = rs.getString("WRITER_ID");
			 Date regdate= rs.getDate("REGDATE");
			 String hit= rs.getString("HIT");
			 String files= rs.getString("FILES");
			 String content=rs.getString("CONTENT");
			/* 
			request.setAttribute("", title);
			request.setAttribute("",writerID);
			request.setAttribute("", regdate);
			request.setAttribute("", hit);
			request.setAttribute("", files);
			request.setAttribute("", content);
			*/	

			 Notice notice = new Notice(
					 id, title, writerID, regdate, hit, files, content 
					 );
			 
			 request.setAttribute("n", notice);
			 
			rs.close();
				st.close();
				con.close();
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 서블릿에서 서블릿으로 전이하는 방법은 2가지가 있음
		// 1. redirect 2. forward
		
		// redirect: 이 페이지에서 저 페이지로 보내버리는 방법
		// ex. 공지사항 페이지에서 로그인페이지로 넘기는 작업
		
		// forward: 이 페이지에서 작업하던 내용을 저 페이지에서 이어받아서 작업하는 방식
		
		
		// forward
		request
		.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp")
		.forward(request, response);
	}
}
