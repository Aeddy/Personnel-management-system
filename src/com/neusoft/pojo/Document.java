package com.neusoft.pojo;

import org.springframework.web.multipart.MultipartFile;

public class Document {
private  Integer  document_id;
private  String  document_title;
private  String  filename;
private  MultipartFile  file;
private  String  remark;
private  java.util.Date document_createdate;
private  User  user;
public Document() {
	super();
	// TODO Auto-generated constructor stub
}
public Integer getDocument_id() {
	return document_id;
}
public void setDocument_id(Integer document_id) {
	this.document_id = document_id;
}
public String getDocument_title() {
	return document_title;
}
public void setDocument_title(String document_title) {
	this.document_title = document_title;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public MultipartFile getFile() {
	return file;
}
public void setFile(MultipartFile file) {
	this.file = file;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public java.util.Date getDocument_createdate() {
	return document_createdate;
}
public void setDocument_createdate(java.util.Date document_createdate) {
	this.document_createdate = document_createdate;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
