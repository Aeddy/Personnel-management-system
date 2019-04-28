package com.neusoft.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.DeptMapper;
import com.neusoft.pojo.Dept;
import com.neusoft.service.DeptService;
import com.neusoft.util.tag.PageModel;
@Service("deptService")
public class DeptServiceImpl implements DeptService {
	@Autowired
	private  DeptMapper  mapper;
public  List<Dept>  selectdept(Dept  dept,PageModel  pageModel)
{
	Map<String,Object>  params=new  HashMap<>();
	
	Integer  recordCount=mapper.count(params);
	pageModel.setRecordCount(recordCount);
	System.out.println("recordCount-->"+recordCount);
	params.put("dept",dept);
	if(recordCount>0)
	{
		params.put("pageModel", pageModel);
	}
	List<Dept> depts=mapper.selectByPage(params);
	return  depts;
}

  public  void   removedept(Integer  dept_id)
  {
	  mapper.deleteDeptById(dept_id);
	  
  }
  
  public  void  medifyDept(Dept  dept)
  {
	  mapper.medifydept(dept);
  }
  public  Dept  querydeptbyid(Integer  dept_id)
  {
	  return  mapper.selectdeptById(dept_id);
  }
  
  public  void  saveDept(Dept  dept)
  {
	  mapper.savedept(dept);
  }
  public  List<Dept>  findAllDept()
  {
	  return  mapper.selectAllDept();
  }
  
}
