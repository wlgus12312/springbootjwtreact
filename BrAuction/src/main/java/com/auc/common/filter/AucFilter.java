package com.auc.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

@Order(0)
public class AucFilter implements Filter{
	
	private static Logger log = LoggerFactory.getLogger(AucFilter.class);
	private List<String> excludedUrls;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		excludedUrls = new ArrayList<String>();
		//excludedUrls.add("/**/*.js");
		//excludedUrls.add("/**/*.css");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			
		HttpServletRequest req = (HttpServletRequest) request;

		String path = req.getServletPath();
		
		log.info("###### path : " + path);
		
	    if(!excludedUrls.contains(path))
	    {
	    	log.info("###### AucFilter start");
			chain.doFilter(request, response);
			log.info("###### AucFilter end");
	    }else {
	    	log.info("###### excludedUrls");
	    }    	
    	
	}
	
	@Override
	public void destroy() {
		
	}
	
	

}
