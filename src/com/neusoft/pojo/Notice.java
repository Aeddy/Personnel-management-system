package com.neusoft.pojo;

public class Notice {
private  Integer  notice_id;
private  String  notice_title;
private  String  notice_content;
private  java.util.Date  notice_createdate;
private  User  user;
public Notice() {
	super();
	// TODO Auto-generated constructor stub
}
public Integer getNotice_id() {
	return notice_id;
}
public void setNotice_id(Integer notice_id) {
	this.notice_id = notice_id;
}
public String getNotice_title() {
	return notice_title;
}
public void setNotice_title(String notice_title) {
	this.notice_title = notice_title;
}
public String getNotice_content() {
	return notice_content;
}
public void setNotice_content(String notice_content) {
	this.notice_content = notice_content;
}
public java.util.Date getNotice_createdate() {
	return notice_createdate;
}
public void setNotice_createdate(java.util.Date notice_createdate) {
	this.notice_createdate = notice_createdate;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}



}
