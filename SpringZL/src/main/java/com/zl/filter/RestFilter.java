package com.zl.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RestFilter implements Filter{
	private static Logger log = LogManager.getLogger(RestFilter.class.getName());
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String addr = request.getRemoteAddr();
		String host = request.getRemoteHost();
		log.debug(addr+host);
	}

	@Override
	public void destroy() {
		
	}

}
