package com.auc.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.auc.common.vo.ResolverMap;

public interface MainService {

	Map<Object, String> selectUser() throws Exception;
	
	List<HashMap<Object, Object>> selectData() throws Exception;

	List<Map<Object, Object>> selectMenuList() throws Exception;

}
