package com.auc.main.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	   @Autowired
	   MainMapper mainMapper;
	   
	   @Autowired
	   PasswordEncoder passwordEncoder;
	   
	   @Override 
	   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		   
		   Map<String, String> paraMap = new HashMap<String, String>();
		   paraMap.put("user_id", username);
		   
	       Map<String, String> selMap = null;
			
		   selMap = mainMapper.signIn(paraMap);
				   
		   if (selMap.get("id").equals(username)) { 
		       return new User(selMap.get("id"), selMap.get("pw"), new ArrayList<>()); 
	       } else { 
	           throw new UsernameNotFoundException("User not found with username: " + username); 
	       }
	  }
			

		public int signUp(Map<String, String> signMap) throws Exception{
			
			int result = 0;
			
			String encodePwd = passwordEncoder.encode(signMap.get("user_pw"));
			
			System.out.println(encodePwd);
			signMap.put("user_enpw", encodePwd);
					
			result = mainMapper.signUp(signMap);
						
			return result;
		}
		

		public int signIn(Map<String, String> signMap) throws Exception{
			
			int result = 0;
			
			Map<String, String> selMap = null;
			
			selMap = mainMapper.signIn(signMap);
			
			String encodePwd = passwordEncoder.encode(signMap.get("user_pw"));
			
			if(selMap.get("pw").isEmpty()) {
				return result = 2;
			}else {				
				result = passwordEncoder.matches(signMap.get("user_pw"), selMap.get("pw")) ?  1 : 0;				
				return result;
			}
			
		}	   

	
	
}
