package com.nucleus.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nucleus.dto.UserDto;
import com.nucleus.service.UserService;

@Service
@Transactional
public class LoginDao extends JdbcDaoSupport implements LoginDaoInterface{
	
	@Autowired
	public LoginDao(DataSource dataSource){
	this.setDataSource(dataSource);
	}
	
	@Override
	public UserDto findUserInfo(String userName) {


		String sql = "Select u.Username,u.Password "//
                + " from Users u where u.Username = ? ";
 
        Object[] params = new Object[] { userName };
        UserService mapper = new UserService();
        try {
            UserDto userDto = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userDto;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}

	@Override
	public List<String> getUserRoles(String userName) {
		String sql = "Select r.User_Role "//
                + " from User_Roles r where r.Username = ? ";
         
        Object[] params = new Object[] { userName };
         
        List<String> roles = this.getJdbcTemplate().queryForList(sql,params, String.class);
         
        return roles;
	}

}
