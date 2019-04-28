package com.neusoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neusoft.pojo.Job;
import com.neusoft.service.JobService;
import com.neusoft.util.tag.PageModel;

@Controller
@RequestMapping("/job")
public class JobController {
	@Autowired
	@Qualifier("jobService")
	private  JobService  jobService;
	@RequestMapping("/selectJob")
	//分页查询职位信息
	public  ModelAndView  selectJob(ModelAndView  mv,@ModelAttribute  Job  job,Integer  pageIndex)
	{
		System.out.println("job"+job);
		PageModel  pageModel  =new  PageModel();
		if(pageIndex!=null)
		{
			pageModel.setPageIndex(pageIndex);
		}
		List<Job> jobs=jobService.selectjob(job, pageModel);
		
		mv.addObject("jobs",jobs);
		mv.addObject("pageModel",pageModel);
		mv.setViewName("jobmessage");
		return mv;
	}
	@RequestMapping("/removeJob")
	//移除职位信息
	public  ModelAndView  removeJob(String  ids,ModelAndView  mv)
	{
		String   []idsarray=ids.split(",");
		for(String  job_id:idsarray)
		{
			jobService.removejob(Integer.parseInt(job_id));
			mv.setViewName("redirect:/job/selectJob.action");
		}
		
     return mv;
		
	}
	@RequestMapping("/updateJob")
	//修改更新职位信息
	public  ModelAndView  updateDept(ModelAndView  mv,@ModelAttribute  Job  job,String  flag)
	{
		if(flag.equals("1"))
		{
			   Job target=jobService.queryjobbyid(job.getJob_id());
			   
			   mv.addObject("job",target);
			   
			   mv.setViewName("showUpdateJob");
		}else{
			jobService.medifyJob(job);
			
			mv.setViewName("redirect:/job/selectJob.action");
		}
		return mv;
	}
	
	@RequestMapping("/addJob")
	//添加职位信息
	public  ModelAndView  addJob(ModelAndView mv,Job  job,String  flag)
	{
		if(flag.equals("1")){
		
		mv.setViewName("showAddJob");
		}else{
			jobService.saveJob(job);
			mv.setViewName("redirect:/job/selectJob.action");
		}
		return mv;
	}
}





