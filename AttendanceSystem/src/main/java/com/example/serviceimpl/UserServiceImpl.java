package com.example.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Faculty;

import com.example.repository.FacultyRepository;


@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService
{
	@Autowired
	FacultyRepository repo;

    @Transactional(readOnly = true)
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
    	Faculty user1 =  repo.findByUsername(username);
	    UserBuilder builder = null;
	    if (user1 != null) 
	    {
	      builder = org.springframework.security.core.userdetails.User.withUsername(username);
	      builder.disabled(!user1.isEnabled());
	      builder.password(user1.getPassword());
	      String[] authorities = new String[]{user1.getAuthority()} ;

	      builder.authorities(authorities);
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }
	    return builder.build();
	  }
}