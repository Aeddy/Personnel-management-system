package com.neusoft.service;

import java.util.List;

import com.neusoft.pojo.Employee;
import com.neusoft.util.tag.PageModel;

public interface EmployeeService {
	public  List<Employee>  selectemployee(Employee  employee,PageModel  pageModel);



	public  void  removeemployee(Integer  employee_id);

	public  void  medifyEmployee(Employee employee);

	public  Employee  queryemployeebyid(Integer  employee_id);

	public  void  saveEmployee(Employee  employee);
}
