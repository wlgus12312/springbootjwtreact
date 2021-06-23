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
    
    @RequestMapping(value="/api/test", method=RequestMethod.POST)
	public Map<Object, Object> test(ResolverMap resolverMap) throws Exception{
		
    	log.info(resolverMap.toString());
    	
		ModelAndView mv = new ModelAndView();
		
		List<HashMap<Object, Object>> reList = new ArrayList<HashMap<Object, Object>>();
		
		HashMap<Object, Object> reMap1 = new HashMap<Object, Object>();
		HashMap<Object, Object> reMap2 = new HashMap<Object, Object>();
		
		reMap1.put("id", "wlgus12312");
		reMap1.put("name", "김지현");
		reMap2.put("id", "brain");
		reMap2.put("name", "브레인");
				
		reList.add(reMap1);
		reList.add(reMap2);
		
		Map reMap = new HashMap();
		reMap.put("userList", reList);
        
		return reMap;
	}
    
    @RequestMapping(value="/api/menuList", method=RequestMethod.POST)
	public Map<Object, Object> menuList() throws Exception{
    
    	List<Map<Object, Object>> reList = null;
    	
    	reList = mainService.selectMenuList();
    	    	
    	Map<Object, Object> reMap = new HashMap<Object, Object>();
    	
    	reMap.put("menuList", reList);
    	
    	return reMap;
    	
    }	
    
    @RequestMapping(value="/api/login", method=RequestMethod.POST)
    public  Map<Object, Object> login()throws Exception{
    	
    	Map<Object, Object> reMap = new HashMap<Object, Object>();
    	
    	loginUser.setId("test");
    	
    	log.info("login@@@@@" + loginUser.getId());
    	
    	reMap.put("data", "login");
    	
    	return reMap;
    }
    
    @RequestMapping(value="/api/check", method=RequestMethod.POST)
    public  Map<Object, Object> check()throws Exception{
    	
    	Map<Object, Object> reMap = new HashMap<Object, Object>();
    	
    	log.info("check@@@@@" + loginUser.getId());
    	
    	reMap.put("data", "check");
    	
    	return reMap;
    }
    
    @RequestMapping(value="/api/testView", method=RequestMethod.POST)
    public String testView()throws Exception{
    	
    	String t = "12345678 asdasd";
    	int tCnt = t.indexOf(" ");
    	
    	t.substring(0, tCnt);
    	
    	log.info(t.substring(tCnt+1, t.length()));
    	
    	
    	return "testView";
    }
    
    
    
    

}
