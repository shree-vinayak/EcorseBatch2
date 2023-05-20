package com.sv.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sv.dao.LoginDao;
import com.sv.entity.LoginEntity;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private LoginDao logindao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginEntity loginEntityFromDb = logindao.getLoginEntityById(username);
		if(loginEntityFromDb == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new User(loginEntityFromDb.getUsername(), 
				loginEntityFromDb.getPassword(), getAuthority(loginEntityFromDb.getRole()));
	}
	
	
	private List<SimpleGrantedAuthority> getAuthority(String role) {
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}

}
