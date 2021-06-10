package com.auc.common.exception;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AucErrorController implements ErrorController {

	private static Logger log = LoggerFactory.getLogger(AucErrorController .class);

	@RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request, HttpServletResponse response) {
				
		ModelAndView mv = new ModelAndView();		
		
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        if (status != null) {
            int statusCode = Integer.valueOf(status.toString());
            
            mv.setViewName("/error/400");
            
            return mv;
        }
        
        mv.setViewName("/error/400");
        
        return mv;
    }

	
}
