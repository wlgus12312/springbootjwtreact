package com.auc.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MainService {

	List<HashMap<Object, Object>> selectData() throws Exception;

	List<Map<Object, Object>> selectMenuList() throws Exception;

}
