package com.sv.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sv.entity.HOSPITAL_LOGIN;
import com.sv.repository.Repo_HOSPITAL_LOGIN;


@Service
public class UserService implements UserDetailsService
{
    @Autowired
	private Repo_HOSPITAL_LOGIN  rep; 
	
    
    
    @Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		HOSPITAL_LOGIN user = rep.getUserByLoginidEntered(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getLoginid(), 
				user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	public HOSPITAL_LOGIN findOne(String username)
	{
        return rep.getUserByLoginidEntered(username);	
	}
	

}
