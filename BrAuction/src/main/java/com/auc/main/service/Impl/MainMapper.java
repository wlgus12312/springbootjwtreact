package com.auc.main.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface MainMapper {
	
	List<HashMap<Object, Object>> selectData();

	List<Map<Object, Object>> selectMenuList();

}
