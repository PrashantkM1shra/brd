package com.nucleus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nucleus.dao.LoginDao;
import com.nucleus.dao.LoginDaoInterface;
import com.nucleus.dto.UserDto;

@Service
public class LoginAuthenticationService  implements UserDetailsService  {

		@Autowired
	    private LoginDaoInterface userDaoI;
		
		 @Override
		    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		        UserDto userDto = userDaoI.findUserInfo(username);
		        System.out.println("UserDto= " + userDto);
		 
		        if (userDto == null) {
		            throw new UsernameNotFoundException("User " + username + " was not found in the database");
		        }
		         
		        // [USER,ADMIN,..]
		        List<String> roles= userDaoI.getUserRoles(username);
		         
		        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
		        if(roles!= null)  {
		            for(String role: roles)  {
		                // ROLE_USER, ROLE_ADMIN,..
		                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
		                grantList.add(authority);
		            }
		        }        
		         
		        UserDetails userDetails = (UserDetails) new User(userDto.getUserName(), //
		        		userDto.getPassword(),grantList);
		 
		        return userDetails;
		    }

}
