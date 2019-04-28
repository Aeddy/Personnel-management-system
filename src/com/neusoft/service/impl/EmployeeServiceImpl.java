package com.neusoft.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.EmployeeMapper;
import com.neusoft.pojo.Employee;
import com.neusoft.service.EmployeeService;
import com.neusoft.util.tag.PageModel;

@Service("employeeService")
public class EmployeeServiceImpl implements  EmployeeService {
@Autowired
private  EmployeeMapper  mapper;
	
public  List<Employee>  selectemployee(Employee  employee,PageModel  pageModel)
{
	Map<String,Object>  params=new  HashMap<>();
	Integer  recordCount  =mapper.count(params);
	System.out.println("recordCount-->"+recordCount);
	pageModel.setRecordCount(recordCount);
	params.put("employee", employee);
	if(recordCount>0)
	{
		params.put("pageModel", pageModel);
	}
	List<Employee> employees=mapper.selectByPage(params);
	return  employees;
}



public  void  removeemployee(Integer  employee_id)
{
	mapper.deleteById(employee_id);
}

public  void  medifyEmployee(Employee employee)

{
	mapper.update(employee);
}

public  Employee  queryemployeebyid(Integer  employee_id)
{
	return  mapper.selectById(employee_id);
}

public  void  saveEmployee(Employee  employee)

{
	mapper.save(employee);
}
}
