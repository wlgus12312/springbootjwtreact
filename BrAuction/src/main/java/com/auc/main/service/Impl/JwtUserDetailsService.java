package com.auc.main.service.Impl;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	   @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		    
		   //DB 사용자 id, password 조회해서 비교
	        if ("user_id".equals(username)) {
	            return new User("user_id", "$2a$10$m/enYHaLsCwH2dKMUAtQp.ksGOA6lq7Fd2pnMb4L.yT4GyeAPRPyS",
	                new ArrayList<>());
	        } else {
	            throw new UsernameNotFoundException("User not found with username: " + username);
	        }
	    } 
	
	
}
