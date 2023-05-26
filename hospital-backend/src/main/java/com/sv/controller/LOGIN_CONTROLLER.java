package com.sv.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.config.JwtTokenUtil;
import com.sv.entity.HOSPITAL_LOGIN;
import com.sv.model.AuthToken;
import com.sv.model.GeneralResponseBody;
import com.sv.model.LoginUser;
import com.sv.repository.Repo_HOSPITAL_LOGIN;
import com.sv.service.UserService;



@RestController
@RequestMapping("/hospitals")
@CrossOrigin(allowedHeaders="*",origins="*")
public class LOGIN_CONTROLLER {
	
	
	@Autowired
	Repo_HOSPITAL_LOGIN userrepo;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> register(
    		@RequestParam("loginid")String username,
    		@RequestParam("password")String password,
    		HttpServletRequest req
    		) throws AuthenticationException {
    	
           LoginUser loginUser=new LoginUser();
           loginUser.setUsername(username);
           loginUser.setPassword(password);
           
           
           HOSPITAL_LOGIN ux=userService.findOne(loginUser.getUsername());
           
           //Validate username and password manually.
           if(ux!=null)
           {
	           if(new BCryptPasswordEncoder().matches(loginUser.getPassword(), ux.getPassword()))
	           {
	        	   System.out.println("Final Root Matched");
	           }
	           else
	           {
	        	   System.out.println("Final Root CAN NOT Matched");
	        	   return new ResponseEntity<AuthToken>(
							new AuthToken(null, username, null, null, false, "Username Password Does Not Match."),HttpStatus.OK);
	           }
           }
           else
           {
        	   System.out.println("No Data Found by ID");
        	   return new ResponseEntity<AuthToken>(
						new AuthToken(null, username, null, null, false, "Username Password Does Not Match."),HttpStatus.OK);
           }
           
    	   final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                ));
    	   
    	   SecurityContextHolder.getContext().setAuthentication(authentication);
           final String token = jwtTokenUtil.generateToken(ux);
           
        		   return new ResponseEntity<AuthToken>(
   						new AuthToken(token, username, ux.getRole(), ux.getStatus(), true, "Logged In Successfully."),HttpStatus.OK); 
        	   
    }
    
    
      @PostMapping("/change-password")
      public GeneralResponseBody getChangePassword(
    		  @RequestParam("loginid")String loginid_e,
    		  @RequestParam("password")String password_e,
    		  @RequestParam("newpassword")String newpassword_e)
      {
    	  String loginid=loginid_e;
		  String password=password_e;
		  String newpassword=newpassword_e;
    	  
    	  GeneralResponseBody resp=new GeneralResponseBody();
    	  HOSPITAL_LOGIN user=userrepo.getUserByLoginidEntered(loginid);
    	  BCryptPasswordEncoder bcpass=new BCryptPasswordEncoder();
    	  
    	  if(bcpass.matches(password, user.getPassword()))
    	  {
    	     int n=userrepo.updatePassword(loginid,bcpass.encode(newpassword));
    	     if(n>0)
    	     {
    		    resp.setFlag(true);
    		    resp.setMsg("Password Changed Successfully.");
    	     }
    	     else
    	     {
    		    resp.setFlag(false);
    		    resp.setMsg("Password Can Not Changed.");
    	     }
    	  }
    	  else
    	  {
    		  resp.setFlag(false);
  		      resp.setMsg("Password Can Not Changed As Old Password Does Not Matched.");
    	  }
    	     return resp;
          }
      
     
}
