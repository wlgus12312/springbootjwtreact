package com.auc.main.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auc.main.service.MainService;

@Service("MainService")
public class MainServiceImpl implements MainService{

	private static Logger log = LoggerFactory.getLogger(MainServiceImpl.class);
	
	@Autowired
	MainMapper mainMapper;
	
	@Override
	public List<HashMap<Object, Object>> selectData() throws Exception {
		
		List<HashMap<Object, Object>> list = null;
		
		list = mainMapper.selectData();
		
		return list;
	}

	@Override
	public List<Map<Object, Object>> selectMenuList() throws Exception {
		
		List<Map<Object, Object>> reList = null;
		
		reList = mainMapper.selectMenuList();
		
		return reList;
	}

}
