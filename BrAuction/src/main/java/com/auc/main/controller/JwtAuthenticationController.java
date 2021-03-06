package com.auc.main.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auc.common.config.JwtTokenUtil;
import com.auc.common.vo.JwtRequest;
import com.auc.common.vo.JwtResponse;
import com.auc.common.vo.ResolverMap;
import com.auc.main.service.Impl.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	
	private static Logger log = LoggerFactory.getLogger(JwtAuthenticationController.class);
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
    private JwtUserDetailsService userDetailsService;	
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public Map<Object, Object> signUp(ResolverMap resolverMap) throws Exception{
		    	
    	int result = 0;    	    	
    	result = userDetailsService.signUp(resolverMap.getMap());
		Map<Object, Object> reMap = new HashMap<Object, Object>();
		reMap.put("result", result);
    	
		return reMap;
	}
	
	@RequestMapping(value="/signIn", method=RequestMethod.POST)
	public Map<Object, Object> signIn(ResolverMap resolverMap) throws Exception{
		    	
    	int result = 0;    	    	
    	result = userDetailsService.signIn(resolverMap.getMap());
    	Map<Object, Object> reMap = new HashMap<Object, Object>();
		reMap.put("result", result);
		
		return reMap;
		
	}
		
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    	
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        
        return ResponseEntity.ok(new JwtResponse(token));
    	
    }
    
    private void authenticate(String username, String password) throws Exception {    	
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
	
	

}
