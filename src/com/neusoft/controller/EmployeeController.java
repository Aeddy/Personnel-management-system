package com.neusoft.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neusoft.pojo.Dept;
import com.neusoft.pojo.Employee;
import com.neusoft.pojo.Job;
import com.neusoft.service.DeptService;
import com.neusoft.service.EmployeeService;
import com.neusoft.service.JobService;
import com.neusoft.util.tag.PageModel;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	//员工操作
	private  EmployeeService  employeeService;
	@Autowired
	private  DeptService   deptService;
	@Autowired
	private  JobService    jobService;
	@RequestMapping("/selectEmployee")
	//分页查询员工信息
	public  ModelAndView  selectEmployee(Integer  job_id,Integer dept_id,ModelAndView  mv,@ModelAttribute  Employee  employee,Integer  pageIndex)
	{
		//this.genericAssociation(job_id,dept_id,employee);
		System.out.println("employee"+employee);
		PageModel  pageModel  =new  PageModel();
		if(pageIndex!=null)
		{
			pageModel.setPageIndex(pageIndex);
		}
		List<Dept>  depts=  deptService.findAllDept();
		List<Job>	jobs=jobService.findAllJob();
		List<Employee> employees=employeeService.selectemployee(employee, pageModel);
		
		mv.addObject("jobs",jobs);
		mv.addObject("depts",depts);
		mv.addObject("employees",employees);
		mv.addObject("pageModel",pageModel);
		mv.setViewName("employeemessage");
		return mv;
	}
	@RequestMapping("/removeEmployee")
	//移除员工信息
	public  ModelAndView  removeEmployee(String  ids,ModelAndView  mv)
	{
		String   []idsarray=ids.split(",");
		for(String  job_id:idsarray)
		{
			employeeService.removeemployee(Integer.parseInt(job_id));
			mv.setViewName("redirect:/employee/selectEmployee.action");
		}
		
     return mv;
		
	}
	@RequestMapping("/updateEmployee")
	//修改更新员工信息
	public  ModelAndView  updateEmployee(Integer job_id,Integer  dept_id,ModelAndView  mv,@ModelAttribute  Employee  employee,String  flag)
	{
		if(flag.equals("1"))
		{
			   Employee target=employeeService.queryemployeebyid(employee.getEmployee_id());
			   Date  date =target.getEmployee_birthday();
			   SimpleDateFormat   simpleDateFormat  =new  SimpleDateFormat("yyyy-MM-dd");
			   String  dt=simpleDateFormat.format(date);
			   mv.addObject("dt",dt);
			   List<Dept> depts=deptService.findAllDept();
			   List<Job> jobs=jobService.findAllJob();
			   mv.addObject("depts",depts);
			   mv.addObject("jobs",jobs);
			   mv.addObject("employee",target);
			   
			   mv.setViewName("showUpdateEmployee");
		}else{
			employeeService.medifyEmployee(employee);
			
			mv.setViewName("redirect:/employee/selectEmployee.action");
		}
		return mv;
	}
	
	@RequestMapping("/addEmployee")
	//添加员工信息
	public  ModelAndView  addJob(Integer  job_id,Integer  dept_id,ModelAndView mv,Employee  employee,String  flag)
	{
		List<Dept>  depts=deptService.findAllDept();
		List<Job>   jobs=jobService.findAllJob();
		if(flag.equals("1")){
		mv.addObject("depts",depts);
		mv.addObject("jobs",jobs);
		mv.setViewName("showAddEmployee");
		}else{
			employeeService.saveEmployee(employee);
			mv.setViewName("redirect:/employee/selectEmployee.action");
		}
		return mv;
	}
	
	
	
	
}
