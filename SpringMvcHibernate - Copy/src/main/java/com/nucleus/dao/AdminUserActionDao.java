package com.nucleus.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nucleus.dto.CustomerDto;
import com.nucleus.dto.UserDto;
import com.nucleus.security.EncodedPasswordGenerator;

@Repository
public class AdminUserActionDao implements AdminUserActionDaoInterface{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	EncodedPasswordGenerator encodedPasswordGenerator;

	@Override
	public boolean addUser(UserDto user) {
		try {
			String password=encodedPasswordGenerator.encryptPwd(user.getPassword());   // method called to encrypt password
			user.setPassword(password);
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateUser(UserDto user) {
		try {
			String password=encodedPasswordGenerator.encryptPwd(user.getPassword());   // method called to encrypt password
			user.setPassword(password);
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public UserDto getUser(int userId) {
		Session session = sessionFactory.openSession();
		UserDto user = (UserDto) session.get(UserDto.class, userId);
		session.close();
		return user;
	}

}
