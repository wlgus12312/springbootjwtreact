package com.auc.main.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.auc.common.vo.LoginUser;
import com.auc.common.vo.ResolverMap;
import com.auc.main.service.MainService;

@RestController
public class MainController {

	private static Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	MainService mainService;
	
	@Resource
	LoginUser loginUser;

    @RequestMapping(value="/api/menuList", method=RequestMethod.POST)
	public Map<Object, Object> menuList() throws Exception{
    
    	List<Map<Object, Object>> reList = null;    	
    	reList = mainService.selectMenuList();    	    	
    	Map<Object, Object> reMap = new HashMap<Object, Object>();    	
    	reMap.put("menuList", reList);    	
    	return reMap;     
    	
    }	
    
    
    
    
    

}
