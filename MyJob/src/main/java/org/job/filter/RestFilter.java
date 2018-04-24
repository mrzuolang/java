package org.job.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.job.bo.RedisBO;
import org.job.util.ThreadSession;
import org.springframework.beans.factory.annotation.Autowired;

public class RestFilter implements Filter{
	private static Logger log = LogManager.getLogger(RestFilter.class.getName());
	@Autowired
	private RedisBO redisBO;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String addr = request.getRemoteAddr();
		String host = request.getRemoteHost();
		log.debug(addr+host);
		HttpServletRequest req = (HttpServletRequest)request ;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
			if("token".equals(cookie.getName())) {
				//令牌内容
				String uuid = cookie.getValue();
				String jsonUserVO = redisBO.getValue(uuid);
				if(jsonUserVO!=null) {
					chain.doFilter(request, response);	
					ThreadSession.THREAD_SESSION.set(uuid);
				}
			}
		}
        chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
