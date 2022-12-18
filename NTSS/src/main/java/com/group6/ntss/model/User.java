package com.group6.ntss.model;
import javax.persistence.*;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long user_id;
	private String email;
	private String password;
	private String user_type;
    
    public Long getUserId() {
		return user_id;
	}

	public void setUserId(Long user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return user_type;
	}

	public void setUserType(String user_type) {
		this.user_type = user_type;
	}
	
}
