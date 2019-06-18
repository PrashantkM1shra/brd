package com.nucleus.service;

import com.nucleus.dto.CustomerDto;
import com.nucleus.dto.UserDto;

public interface AdminUserActionServiceInterface {
	
	public boolean addUser(UserDto user);

	public boolean updateUser(UserDto user);

	public UserDto getUser(int userId);

}
