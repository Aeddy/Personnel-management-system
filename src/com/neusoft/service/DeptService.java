package com.neusoft.service;

import java.util.List;

import com.neusoft.pojo.Dept;
import com.neusoft.util.tag.PageModel;

public interface DeptService {
public  List<Dept>  selectdept(Dept  dept,PageModel  pageModel);



public  void  removedept(Integer  dept_id);

public  void  medifyDept(Dept dept);

public  Dept  querydeptbyid(Integer  dept_id);

public  void  saveDept(Dept  dept);

public  List<Dept> findAllDept();
}
