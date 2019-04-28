package com.neusoft.dao;
import  java.util.List;
import java.util.Map;
import  static  com.neusoft.util.common.HrmConstants.DEPTTABLE;
import  com.neusoft.dao.provider.DeptDynaSqlProvider;
import com.neusoft.dao.provider.UserDynaSqlProvider;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import  com.neusoft.pojo.Dept;
import com.neusoft.pojo.User;
public interface DeptMapper {
	//模糊查询职工
	@SelectProvider(type=DeptDynaSqlProvider.class,method="selectWhitParam")
	public  List<Dept> selectByPage(Map<String,Object> params);
	
	//模糊查询统计部门数据条数
	@SelectProvider(type=DeptDynaSqlProvider.class,method="count")
	public  Integer  count(Map<String,Object> params);
	
	//查询所有部门
	@Select("select  *    from  "+DEPTTABLE+" ")
	public  List<Dept>  selectAllDept();
	
	
	//根据部门id查询部门信息
	@Select("select  * from  "+DEPTTABLE+"  where  dept_id=#{dept_id}")
	public  Dept  selectdeptById(Integer  dept_id);
	
	//根据id删除部门信息
	
	@Delete("delete  from  "+DEPTTABLE+"  where  dept_id=#{dept_id}" )
	public  void   deleteDeptById(@Param("dept_id")Integer  dept_id);
	
   //动态更新部门信息
	@SelectProvider(type=DeptDynaSqlProvider.class,method="updatedept")
	public  void   medifydept(Dept  dept);
	
	@SelectProvider(type=DeptDynaSqlProvider.class,method="insertdept") 
	 public  void  savedept(Dept  dept);
	
}
