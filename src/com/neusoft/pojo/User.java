package com.neusoft.pojo;

import java.util.Date;

public class User {

	
	private Integer  user_id;
	
	private  String  user_name;
	private String user_loginname;
	private  String  user_password;
	private  Integer  user_status;
	private  Date  user_createdate;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String user_name, String user_loginname, String user_password) {
		super();
		this.user_name = user_name;
		this.user_loginname = user_loginname;
		this.user_password = user_password;
	}

	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_loginname() {
		return user_loginname;
	}
	public void setUser_loginname(String user_loginname) {
		this.user_loginname = user_loginname;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public Integer getUser_status() {
		return user_status;
	}
	public void setUser_status(Integer user_status) {
		this.user_status = user_status;
	}
	public Date getUser_createdate() {
		return user_createdate;
	}
	public void setUser_createdate(Date user_createdate) {
		this.user_createdate = user_createdate;
	}
	
}
