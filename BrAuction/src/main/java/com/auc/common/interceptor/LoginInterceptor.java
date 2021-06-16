package com.auc.common.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.auc.common.vo.LoginUser;


@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	private static Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		
//		String sessionYn = (String) httpSession.getAttribute("login_yn");
				
//		if(sessionYn.equals("")) {
//			return false;
//		}		
		
		return true;		
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	                       ModelAndView modelAndView) throws Exception {
	        // TODO Auto-generated method stub
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
    }
}
