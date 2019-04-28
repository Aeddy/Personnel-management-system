package com.neusoft.dao;

import static com.neusoft.util.common.HrmConstants.JOBTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.neusoft.dao.provider.JobDynaSqlProvider;
import com.neusoft.pojo.Job;

public interface JobMapper {
	//模糊查询职工
	@SelectProvider(type=JobDynaSqlProvider.class,method="selectWhitParam")
	public  List<Job> selectByPage(Map<String,Object> params);
	
	//模糊查询统计部门数据条数
	@SelectProvider(type=JobDynaSqlProvider.class,method="count")
	public  Integer  count(Map<String,Object> params);
	
	//查询所有部门
	@Select("select  *    from  "+JOBTABLE+" ")
	public  List<Job>  selectAllJob();
	
	
	//根据部门id查询部门信息
	@Select("select  * from  "+JOBTABLE+"  where  job_id=#{job_id}")
	public  Job  selectjobById(Integer  job_id);
	
	//根据id删除部门信息
	
	@Delete("delete  from  "+JOBTABLE+"  where  job_id=#{job_id}" )
	public  void   deleteJobById(@Param("job_id")Integer  job_id);
	
   //动态更新部门信息
	@SelectProvider(type=JobDynaSqlProvider.class,method="updatejob")
	public  void   medifyjob(Job  job);
	
	@SelectProvider(type=JobDynaSqlProvider.class,method="insertjob") 
	 public  void  savejob(Job  job);
	
	
}
