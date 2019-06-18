package com.nucleus.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nucleus.dto.UserDto;

public class UserService implements RowMapper<UserDto>  {

	@Override
	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		 String userName = rs.getString("Username");
	        String password = rs.getString("Password");
	 
	        return null;//new UserDto(userName, password);
	}

}
