package com.nucleus.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="AuthenticUsers02")
@SequenceGenerator(name="userSeq",sequenceName="userSeq")
public class UserDto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="userSeq")
	private int userId;
	
	@Pattern(regexp = "[a-z A-Z0-9]*", message="Can enter Alpha-numeric data")
	@NotNull(message="Please enter User Name")
	@Length(min=1, max=30, message="Should not be more than 30 characters")
	private String userName;
	
	//@Pattern.List({
	    //@Pattern(regexp = "[a-z][A-Z][0-9]\\S+$)", message = "Password must contain one digit.")
	    /*@Pattern(regexp = "(?=.*[a-z])", message = "Password must contain one lowercase letter."),
	    @Pattern(regexp = "(?=.*[A-Z])", message = "Password must contain one uppercase letter."),
	    @Pattern(regexp = "(?=\\S+$)", message = "Password must contain no whitespace.")
	})*/
	@NotNull(message="Please enter User Password")
	private String password;
	
	@NotNull(message="Please enter User Role")
	@Length(min=9, max=10, message="Should not be less than 9 and more than 10 characters")
	private String user_role;
	private int enabled;
	/*public UserDto(String userName, String password) {
		
		this.userName = userName;
		this.password = password;
	}*/
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

}
