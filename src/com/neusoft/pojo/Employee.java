package com.neusoft.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
private  Integer  employee_id;
private  Dept   dept;
private  Job  job;
private  String  employee_name;
private  String  card_id;
private  String  employee_address;
private  String  employee_postcode;
private  String  employee_tel;
private  String employee_phone;
private   String  employee_qqnum;
private  String  employee_email;
private   Integer  employee_sex;
private   String employee_party;
@DateTimeFormat(pattern="yyyy-MM-dd")
private  Date  employee_birthday;
private  String  employee_race;
private  String  employee_education;
private  String  employee_speciality;
private  String  employee_hobby;
private  String   employee_remark;
private  Date  employee_createdate;
public Integer getEmployee_id() {
	return employee_id;
}
public void setEmployee_id(Integer employee_id) {
	this.employee_id = employee_id;
}
public Dept getDept() {
	return dept;
}
public void setDept(Dept dept) {
	this.dept = dept;
}
public Job getJob() {
	return job;
}
public void setJob(Job job) {
	this.job = job;
}
public String getEmployee_name() {
	return employee_name;
}
public void setEmployee_name(String employee_name) {
	this.employee_name = employee_name;
}
public String getCard_id() {
	return card_id;
}
public void setCard_id(String card_id) {
	this.card_id = card_id;
}
public String getEmployee_address() {
	return employee_address;
}
public void setEmployee_address(String employee_address) {
	this.employee_address = employee_address;
}
public String getEmployee_postcode() {
	return employee_postcode;
}
public void setEmployee_postcode(String employee_postcode) {
	this.employee_postcode = employee_postcode;
}
public String getEmployee_tel() {
	return employee_tel;
}
public void setEmployee_tel(String employee_tel) {
	this.employee_tel = employee_tel;
}
public String getEmployee_phone() {
	return employee_phone;
}
public void setEmployee_phone(String employee_phone) {
	this.employee_phone = employee_phone;
}
public String getEmployee_qqnum() {
	return employee_qqnum;
}
public void setEmployee_qqnum(String employee_qqnum) {
	this.employee_qqnum = employee_qqnum;
}
public String getEmployee_email() {
	return employee_email;
}
public void setEmployee_email(String employee_email) {
	this.employee_email = employee_email;
}
public Integer getEmployee_sex() {
	return employee_sex;
}
public void setEmployee_sex(Integer employee_sex) {
	this.employee_sex = employee_sex;
}
public String getEmployee_party() {
	return employee_party;
}
public void setEmployee_party(String employee_party) {
	this.employee_party = employee_party;
}
public Date getEmployee_birthday() {
	return employee_birthday;
}
public void setEmployee_birthday(Date employee_birthday) {
	this.employee_birthday = employee_birthday;
}
public String getEmployee_race() {
	return employee_race;
}
public void setEmployee_race(String employee_race) {
	this.employee_race = employee_race;
}
public String getEmployee_education() {
	return employee_education;
}
public void setEmployee_education(String employee_education) {
	this.employee_education = employee_education;
}
public String getEmployee_speciality() {
	return employee_speciality;
}
public void setEmployee_speciality(String employee_speciality) {
	this.employee_speciality = employee_speciality;
}
public String getEmployee_hobby() {
	return employee_hobby;
}
public void setEmployee_hobby(String employee_hobby) {
	this.employee_hobby = employee_hobby;
}
public String getEmployee_remark() {
	return employee_remark;
}
public void setEmployee_remark(String employee_remark) {
	this.employee_remark = employee_remark;
}
public Date getEmployee_createdate() {
	return employee_createdate;
}
public void setEmployee_createdate(Date employee_createdate) {
	this.employee_createdate = employee_createdate;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(Integer employee_id, Dept dept, Job job, String employee_name, String card_id, String employee_address,
		String employee_postcode, String employee_tel, String employee_phone, String employee_qqnum,
		String employee_email, Integer employee_sex, String employee_party, Date employee_birthday,
		String employee_race, String employee_education, String employee_speciality, String employee_hobby,
		String employee_remark, Date employee_createdate) {
	super();
	this.employee_id = employee_id;
	this.dept = dept;
	this.job = job;
	this.employee_name = employee_name;
	this.card_id = card_id;
	this.employee_address = employee_address;
	this.employee_postcode = employee_postcode;
	this.employee_tel = employee_tel;
	this.employee_phone = employee_phone;
	this.employee_qqnum = employee_qqnum;
	this.employee_email = employee_email;
	this.employee_sex = employee_sex;
	this.employee_party = employee_party;
	this.employee_birthday = employee_birthday;
	this.employee_race = employee_race;
	this.employee_education = employee_education;
	this.employee_speciality = employee_speciality;
	this.employee_hobby = employee_hobby;
	this.employee_remark = employee_remark;
	this.employee_createdate = employee_createdate;
}
@Override
public String toString() {
	return "Employee [employee_id=" + employee_id + ", dept=" + dept + ", job=" + job + ", employee_name="
			+ employee_name + ", card_id=" + card_id + ", employee_address=" + employee_address + ", employee_postcode="
			+ employee_postcode + ", employee_tel=" + employee_tel + ", employee_phone=" + employee_phone
			+ ", employee_qqnum=" + employee_qqnum + ", employee_email=" + employee_email + ", employee_sex="
			+ employee_sex + ", employee_party=" + employee_party + ", employee_birthday=" + employee_birthday
			+ ", employee_race=" + employee_race + ", employee_education=" + employee_education
			+ ", employee_speciality=" + employee_speciality + ", employee_hobby=" + employee_hobby
			+ ", employee_remark=" + employee_remark + ", employee_createdate=" + employee_createdate + "]";
}


}
