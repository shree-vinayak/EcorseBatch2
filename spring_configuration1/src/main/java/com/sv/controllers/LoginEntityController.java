package com.sv.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.config.JwtTokenUtil;
import com.sv.dao.LoginDao;
import com.sv.entity.LoginEntity;
import com.sv.service.LoginService;
import com.sv.utils.ResponseWrapper;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginEntityController {

	@Autowired
	private LoginService loginservice;
	
	
	@Autowired
	private LoginDao logindao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;

//	@PostMapping(name = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseWrapper authenticateTeacher(@RequestBody LoginEntity loginEntity,
//			@RequestParam("logintype")boolean logintype) {
//		return loginservice.authenticate(loginEntity,logintype);
//	}
	
	@GetMapping(name = "/")
	public String applicationStatus(
			) {
		return "Your Application is Up";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object register(
    		@RequestBody LoginEntity loginEntity,
    		@RequestParam("logintype")boolean logintype,
    		HttpServletRequest req
    		) throws AuthenticationException {
		   LoginEntity loginEntityfromdb=logindao.getLoginEntityById(loginEntity.getUsername());
           //Validate username and password manually.
           if(loginEntityfromdb!=null)
           {
	           if(encoder.matches(loginEntity.getPassword(), loginEntityfromdb.getPassword()))
	           {
	        	   System.out.println("password matches");
	           }
	           else
	           {
	        	   System.out.println("password does not match");
	        	   return new ResponseWrapper(null,"Password Does Not Match",false,null);
	           }
           }
           else
           {
        	   System.out.println("No Data Found by ID");
        	   return new ResponseWrapper(null,"User Does Not Exits",false,null);
           }
           
    	   final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		loginEntity.getUsername(),
                		loginEntity.getPassword()
                ));
    	 
    	   
    	   SecurityContextHolder.getContext().setAuthentication(authentication);
           final String token = jwtTokenUtil.generateToken(loginEntityfromdb);
           
        		   return  new ResponseWrapper(loginEntityfromdb, "LoggedIn Successfully", true, token); 
        	   
    }
}
