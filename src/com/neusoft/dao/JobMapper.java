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
	//ģ����ѯְ��
	@SelectProvider(type=JobDynaSqlProvider.class,method="selectWhitParam")
	public  List<Job> selectByPage(Map<String,Object> params);
	
	//ģ����ѯͳ�Ʋ�����������
	@SelectProvider(type=JobDynaSqlProvider.class,method="count")
	public  Integer  count(Map<String,Object> params);
	
	//��ѯ���в���
	@Select("select  *    from  "+JOBTABLE+" ")
	public  List<Job>  selectAllJob();
	
	
	//���ݲ���id��ѯ������Ϣ
	@Select("select  * from  "+JOBTABLE+"  where  job_id=#{job_id}")
	public  Job  selectjobById(Integer  job_id);
	
	//����idɾ��������Ϣ
	
	@Delete("delete  from  "+JOBTABLE+"  where  job_id=#{job_id}" )
	public  void   deleteJobById(@Param("job_id")Integer  job_id);
	
   //��̬���²�����Ϣ
	@SelectProvider(type=JobDynaSqlProvider.class,method="updatejob")
	public  void   medifyjob(Job  job);
	
	@SelectProvider(type=JobDynaSqlProvider.class,method="insertjob") 
	 public  void  savejob(Job  job);
	
	
}
