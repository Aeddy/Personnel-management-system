package com.neusoft.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.JobMapper;
import com.neusoft.pojo.Job;
import com.neusoft.service.JobService;
import com.neusoft.util.tag.PageModel;
	@Service("jobService")
	public class JobServiceImpl implements JobService {
		@Autowired
		private  JobMapper  mapper;
	public  List<Job>  selectjob(Job  job,PageModel  pageModel)
	{
		Map<String,Object>  params=new  HashMap<>();
		
		Integer  recordCount=mapper.count(params);
		pageModel.setRecordCount(recordCount);
		System.out.println("recordCount-->"+recordCount);
		params.put("job",job);
		if(recordCount>0)
		{
			params.put("pageModel", pageModel);
		}
		List<Job> jobs=mapper.selectByPage(params);
		return  jobs;
	}

	  public  void   removejob(Integer  job_id)
	  {
		  mapper.deleteJobById(job_id);
		  
	  }
	  
	  public  void  medifyJob(Job  job)
	  {
		  mapper.medifyjob(job);
	  }
	  public  Job  queryjobbyid(Integer  job_id)
	  {
		  return  mapper.selectjobById(job_id);
	  }
	  
	  public  void  saveJob(Job  job)
	  {
		  mapper.savejob(job);
	  }
	 public  List<Job> findAllJob()
	 {
		 return mapper.selectAllJob();
	 }
}
