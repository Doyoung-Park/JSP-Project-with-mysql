package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")		// 어노테이션 방법 --> xml에서 설정할 필요가 없어짐
public class CharacterEncodingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");	// 읽어들일 때에도 UTF-8로 읽어라..!
		
		chain.doFilter(request, response);	// 필터에서 받은 요청을 서블릿 실행부분으로 넘겨주는 부분!
		//System.out.println("after filter");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
