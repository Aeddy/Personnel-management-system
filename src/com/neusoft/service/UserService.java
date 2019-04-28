package com.neusoft.service;

import java.util.List;

import com.neusoft.pojo.User;
import com.neusoft.util.tag.PageModel;

public interface UserService {
	//查询用户密码进行登录认证
	public  User   querypwd(String user_loginname,String user_password);
	
	//根据用户id查询用户信息
	
	public  User queryuserById(Integer user_id);
	
	//根据用户名查询用户
	
	public  User  queryuserByName(String  user_loginname);
	
	//模糊查询用户信息
	public  List<User>  findUser(User user,PageModel pageModel);
	
	//动态添加用户信息
	public  void  insertUser(User  user);
	
	//根据用户id删除相关用户
	
	public  void  removeuser(Integer  user_id);
	
	//动态更新用户
	
	public   void  modifyuser(User user);
	
	//注册用户
	
	public void zhuCe(User user);
	
}
