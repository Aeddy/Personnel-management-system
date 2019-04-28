package com.neusoft.service;

import java.util.List;

import com.neusoft.pojo.Job;
import com.neusoft.util.tag.PageModel;

public interface JobService {
	public  List<Job>  selectjob(Job  job,PageModel  pageModel);



	public  void  removejob(Integer  job_id);

	public  void  medifyJob(Job job);

	public  Job  queryjobbyid(Integer  job_id);

	public  void  saveJob(Job  job);
	public  List<Job>  findAllJob();
	
}
