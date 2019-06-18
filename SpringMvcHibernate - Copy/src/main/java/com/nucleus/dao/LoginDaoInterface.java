package com.nucleus.dao;

import java.util.List;

import com.nucleus.dto.UserDto;

public interface LoginDaoInterface {
	
	 public UserDto findUserInfo(String userName);
     
	    // [USER,AMIN,..]
	    public List<String> getUserRoles(String userName);
}
