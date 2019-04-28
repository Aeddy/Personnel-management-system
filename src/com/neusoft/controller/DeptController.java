package com.neusoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neusoft.pojo.Dept;
import com.neusoft.service.DeptService;
import com.neusoft.util.tag.PageModel;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	@Qualifier("deptService")
	private  DeptService  deptService;
	@RequestMapping("/selectDept")
	//分页查询部门信息
	public  ModelAndView  selectDept(ModelAndView  mv,@ModelAttribute  Dept  dept,Integer  pageIndex)
	{
		System.out.println("dept"+dept);
		PageModel  pageModel  =new  PageModel();
		if(pageIndex!=null)
		{
			pageModel.setPageIndex(pageIndex);
		}
		List<Dept> depts=deptService.selectdept(dept, pageModel);
		
		mv.addObject("depts",depts);
		mv.addObject("pageModel",pageModel);
		mv.setViewName("deptmessage");
		return mv;
	}
	@RequestMapping("/removeDept")
	//移除相关部门
	public  ModelAndView  removeDept(String  ids,ModelAndView  mv)
	{
		String   []idsarray=ids.split(",");
		for(String  dept_id:idsarray)
		{
			deptService.removedept(Integer.parseInt(dept_id));
			mv.setViewName("redirect:/dept/selectDept.action");
		}
		
     return mv;
		
	}
	@RequestMapping("/updateDept")
	//更新修改部门信息
	public  ModelAndView  updateDept(ModelAndView  mv,@ModelAttribute  Dept  dept,String  flag)
	{
		if(flag.equals("1"))
		{
			   Dept target=deptService.querydeptbyid(dept.getDept_id());
			   
			   mv.addObject("dept",target);
			   
			   mv.setViewName("showUpdateDept");
		}else{
			deptService.medifyDept(dept);
			
			mv.setViewName("redirect:/dept/selectDept.action");
		}
		return mv;
	}
	
	@RequestMapping("/addDept")
	//添加部门信息
	public  ModelAndView  addDept(ModelAndView mv,Dept  dept,String  flag)
	{
		if(flag.equals("1")){
		
		mv.setViewName("showAddDept");
		}else{
			deptService.saveDept(dept);
			mv.setViewName("redirect:/dept/selectDept.action");
		}
		return mv;
	}
}





