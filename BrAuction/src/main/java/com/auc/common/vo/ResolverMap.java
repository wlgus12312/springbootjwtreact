package com.auc.common.vo;

import java.util.HashMap;
import java.util.Map;

public class ResolverMap {

	Map<String, String> map = new HashMap<String, String>();
	
	public Map<String, String> getMap(){return this.map;}
	
	public String get(String key){ return map.get(key); } 
	public void put(String key, String value){ map.put(key, value); }
	public String toString() { return map.toString();}
}
