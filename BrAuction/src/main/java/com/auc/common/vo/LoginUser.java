package com.auc.common.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoginUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String yn;
	private String st_dt;
	private String ed_dt;
		
	public LoginUser() {
		super();
	}

	public LoginUser(String id, String name, String yn, String st_dt, String ed_dt, Map<String, List> confMap) {
		super();
		this.id = id;
		this.name = name;
		this.yn = yn;
		this.st_dt = st_dt;
		this.ed_dt = ed_dt;
	}
			
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYn() {
		return yn;
	}
	public void setYn(String yn) {
		this.yn = yn;
	}
	public String getSt_dt() {
		return st_dt;
	}
	public void setSt_dt(String st_dt) {
		this.st_dt = st_dt;
	}
	public String getEd_dt() {
		return ed_dt;
	}
	public void setEd_dt(String ed_dt) {
		this.ed_dt = ed_dt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", name=" + name + ", yn=" + yn + ", st_dt=" + st_dt + ", ed_dt=" + ed_dt;
	}
	
	
	
	
	
	

}
