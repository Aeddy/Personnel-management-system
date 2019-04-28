package com.neusoft.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.neusoft.dao.UserMapper;
import com.neusoft.pojo.User;
import com.neusoft.service.UserService;
import com.neusoft.util.tag.PageModel;
import com.sun.org.glassfish.gmbal.ManagedAttribute;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private  UserService  userService;
	@RequestMapping("/login")
	//检测登陆信息
	public  ModelAndView  checklogin(HttpSession  session,String user_loginname,String user_password)
	{
		ModelAndView  mv=new  ModelAndView();
		User user=userService.querypwd(user_loginname,user_password);
		if(user!=null)
		{
			session.setAttribute("user", user);
			mv.addObject("success","登录成功！");
			mv.setViewName("main");
			
		}
		else{
			mv.addObject("error","用户名或者密码错误！");
			mv.setViewName("loginForm");
		}
		return mv;
	}
@RequestMapping("/querybyid")
//通过id查询信息
public ModelAndView   querybyid(HttpSession session,Integer user_id )
{
	ModelAndView  mv=new  ModelAndView();
	User u=userService.queryuserById(user_id);
	session.setAttribute("user", u);
	mv.addObject("user_loginname","hhh");
	mv.setViewName("chaxunuserbyid");
	
	return mv;
}

@RequestMapping("/selectUser")
//分页查询用户信息
public  String  selectUser(Integer  pageIndex,@ModelAttribute  User user,Model  model)
{
	System.out.println("user="+user);
	
	PageModel  pageModel=new  PageModel();
	
	if(pageIndex!=null)
	{
		pageModel.setPageIndex(pageIndex);
		
		
	}
	//chaxun用户信息
	
	List<User>  users=userService.findUser(user, pageModel);
	model.addAttribute("users",users);
	model.addAttribute("pageModel",pageModel);
	return "usermessage";
}

@RequestMapping("/queryuserByName")
//根据用户姓名查询用户信息
public  ModelAndView  queryuserByName(String  user_loginname,ModelAndView  mv)
{
	User  user=userService.queryuserByName(user_loginname);
	
	if(user!=null)
	{
		mv.setViewName("usermessage");
		mv.addObject("users",user);
	}
	else{
		mv.addObject("message","此用户为空！");
		mv.setViewName("usermessage");
		
	}
	return mv;
}
@RequestMapping("/addUser")
//添加用户信息
public  ModelAndView   addUser(@ModelAttribute User  user,ModelAndView mv,String flag)
{
	if(flag.equals("1"))
	{
		mv.setViewName("showAddUser");
	}else{
		userService.insertUser(user);
		
		mv.setViewName("redirect:/user/selectUser.action");
	}
	
	return mv;
}
@RequestMapping("/Register")
//注册用户检测
public ModelAndView ZhuCe(@Param("user_name")String user_name,@Param("user_loginname")String user_loginname,@Param("user_password")String user_password, ModelAndView mv)
{
	    User user=new User(user_name,user_loginname,user_password);
		userService.zhuCe(user);
		
		mv.addObject("succcess","注册成功！");
		
		mv.setViewName("loginForm");
	
	return mv;
}




@RequestMapping("/removeUser")
//移除用户信息
public  ModelAndView   removeUser(String  ids,ModelAndView mv)
{
	
	String  []idArray=ids.split(",");
	for(String user_id:idArray){
	userService.removeuser(Integer.parseInt(user_id));
	mv.setViewName("redirect:/user/selectUser.action");

	}
	return mv;
}
@RequestMapping("/updateUser")
//修改更新用户信息
public  ModelAndView  updateUser(ModelAndView  mv,@ModelAttribute User user,String  flag)
{
	if(flag.equals("1"))
	{
		User target=userService.queryuserById(user.getUser_id());
		mv.addObject("user",target);
		mv.setViewName("showUpdateUser");
	}else{
		userService.modifyuser(user);
		mv.setViewName("redirect:/user/selectUser.action");
	}
	return mv;
}
}







