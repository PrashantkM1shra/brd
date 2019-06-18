package com.nucleus.dao;

import com.nucleus.dto.UserDto;

public interface AdminUserActionDaoInterface {
	
	public boolean addUser(final UserDto user);

	public boolean updateUser(UserDto user);

	public UserDto getUser(int userId);

}
