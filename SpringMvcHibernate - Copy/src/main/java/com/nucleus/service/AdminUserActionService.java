package com.nucleus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nucleus.dao.AdminUserActionDao;
import com.nucleus.dao.AdminUserActionDaoInterface;
import com.nucleus.dto.UserDto;

@Service
@Transactional
public class AdminUserActionService implements AdminUserActionServiceInterface{
	
	@Autowired
	AdminUserActionDaoInterface adminUserActionDao;
	
	@Override
	public boolean addUser(UserDto user) {
		
		return adminUserActionDao.addUser(user);
	}

	@Override
	public boolean updateUser(UserDto user) {

		return adminUserActionDao.updateUser(user);
	}

	@Override
	public UserDto getUser(int userId) {

		return adminUserActionDao.getUser(userId);
	}

}
