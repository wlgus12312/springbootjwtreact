package com.auc.common.vo;

import java.io.Serializable;

public class JwtResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5489562268116423537L;
	
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }

}
