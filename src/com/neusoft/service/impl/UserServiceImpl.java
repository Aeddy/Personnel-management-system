package com.neusoft.service.impl;
import  java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.dao.UserMapper;
import com.neusoft.pojo.User;
import com.neusoft.service.UserService;
import com.neusoft.util.tag.PageModel;
@Service("userService")
public class UserServiceImpl implements  UserService{
	@Autowired
	private  UserMapper  mapper;
	//查询用户密码进行登录认证
		public  User   querypwd(String user_loginname,String user_password)
		{
			return  mapper.queryuserpwd(user_loginname,user_password);
		}
		
		//根据用户id查询用户信息
		
		public  User queryuserById(Integer user_id)
		{
			return  mapper.selectuserById(user_id);
		}
		
		//根据用户登录名查询用户
		
		public  User  queryuserByName(String user_loginname)

		{
			
			return  mapper.selectuserByName(user_loginname);
			
		}
		
		
		@Transactional(readOnly=true)
		@Override
		//模糊查询用户信息
		public List<User>  findUser(User user,PageModel  pageModel)
		{
			//当前需要分页的总数据条数
			
			Map<String,Object>  params= new  HashMap<> ();
			params.put("user",user);
			int recordCount = mapper.count(params);
			System.out.println("recordCount-->"+recordCount);
			pageModel.setRecordCount(recordCount);
			if(recordCount>0)
			{
				//开始分页查询数据，查询第几页数据
				
				params.put("pageModel",pageModel);
			}
			
			List<User>  users =mapper.selectuserbyPage(params);
			return users;
			
		}
		@Override
		public  void  insertUser(User user)
		{
			mapper.saveuser(user);
		}
    //根据用户id删除用户
		
		public  void  removeuser(Integer  user_id)
		{
			mapper.deleteuserById(user_id);
			
		}
		
		//动态更新用户信息
		
		public  void  modifyuser(User  user)
		{
			mapper.Updateuser(user);
		}
		
		//注册用户
		
		public void zhuCe(User user)
		{
			mapper.Zhuceuser(user);	
		}
}








