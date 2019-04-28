package com.neusoft.dao.provider;

import static com.neusoft.util.common.HrmConstants.JOBTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.neusoft.pojo.Job;

public class JobDynaSqlProvider {

	public  String   selectWhitParam(Map<String ,Object>  params)
	{
		String   sql=new  SQL(){
			{
				SELECT("*");
				FROM(JOBTABLE);
				if(params.get("job")!=null)
				{
					Job  job=(Job)params.get("job");
					if(job.getJob_name()!=null&&!job.getJob_name().equals(""))
					{
						WHERE("job_name LIKE  CONCAT ('%',#{job.job_name},'%')");
					}
				}
				
			}
		}.toString();
				
		if(params.get("pageModel")!=null)
		{
			sql=sql+" limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
		}
		return sql;		
	}
	
public  String  count(Map<String,Object>  params)
{
	return new  SQL(){
	{
		SELECT("count(*)");
	    FROM(JOBTABLE);
	    if(params.get("job")!=null)
	    {
	    	Job  job=(Job)params.get("job");
	    	if(job.getJob_name()!=null&&!job.getJob_name().equals(""))
	    	{
	    		WHERE("job_name LIKE CONCAT('%',#{job.job_name},'%')");
	    	}
	    	
	    }
	
	}
	}.toString();
}
public String updatejob(Job job){
	
	return new SQL(){
		{
			UPDATE(JOBTABLE);
			if(job.getJob_name() != null){
				SET(" job_name = #{job_name} ");
			}
			if(job.getJob_remark() != null){
				SET(" job_remark = #{job_remark} ");
			}
			
			WHERE(" job_id = #{job_id} ");
		}
	}.toString();
}
public  String   insertjob(Job  job)
{
	return new SQL(){
	{
		INSERT_INTO(JOBTABLE);
		if(job.getJob_name()!=null&&!job.getJob_name().equals(""))
		{
			VALUES("job_name","#{job_name}");
		}
		if(job.getJob_remark()!=null&&!job.getJob_remark().equals(""))
		{
			VALUES("job_remark","#{job_remark}");
		}
	}
	}.toString();
	
	
	
}
	
	
}
