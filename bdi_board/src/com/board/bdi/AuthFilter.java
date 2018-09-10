package com.board.bdi;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {
	private String excludeUris;
    public AuthFilter() {
//    	System.out.println("1. 난 1번만 생성됨.");
    }
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("3. 난 호출될때마다 실행됨.");
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		System.out.println(uri);
		HttpSession hs = req.getSession();
		if(hs.getAttribute("user")==null && !uri.matches(excludeUris)) {
			if(uri.indexOf("Login")==-1 && uri.indexOf("Join")==-1) {
				HttpServletResponse res = (HttpServletResponse)response;
				res.sendRedirect("/views/user/userLogin");
				return;
			}	
		}
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
//		System.out.println("2. 난 1번만 초기화됨.");
		excludeUris = fConfig.getInitParameter("excludeUris");
	}

}
