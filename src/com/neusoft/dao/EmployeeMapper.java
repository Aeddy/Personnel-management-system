package com.neusoft.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import com.neusoft.dao.provider.EmployeeDynaSqlProvider;
import com.neusoft.pojo.Employee;
import static com.neusoft.util.common.HrmConstants.EMPLOYEETABLE;


public interface EmployeeMapper {

	
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="employee_id",property="employee_id"),
		
		@Result(column="employee_birthday",property="employee_birthday",javaType=java.util.Date.class),
		@Result(column="employee_createdate",property="employee_createdate",javaType=java.util.Date.class),
		@Result(column="dept_id",property="dept",
			one=@One(select="com.neusoft.dao.DeptMapper.selectdeptById",
		fetchType=FetchType.EAGER)),
		@Result(column="job_id",property="job",
			one=@One(select="com.neusoft.dao.JobMapper.selectjobById",
		fetchType=FetchType.EAGER))
	})
	List<Employee> selectByPage(Map<String, Object> params);
	
	
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="insertEmployee")
	void save(Employee employee);

	
	@Delete(" delete from "+EMPLOYEETABLE+" where employee_id = #{employee_id} ")
	void deleteById(Integer employee_id);
	
	
	@Select("select * from "+EMPLOYEETABLE+" where employee_id = #{employee_id}")
	@Results({
		@Result(id=true,column="employee_id",property="employee_id"),
		
		@Result(column="employee_birthday",property="employee_birthday",javaType=java.util.Date.class),
		@Result(column="employee_createdate",property="employee_createdate",javaType=java.util.Date.class),
		@Result(column="dept_id",property="dept",
			one=@One(select="com.neusoft.dao.DeptMapper.selectdeptById",
		fetchType=FetchType.EAGER)),
		@Result(column="job_id",property="job",
			one=@One(select="com.neusoft.dao.JobMapper.selectjobById",
		fetchType=FetchType.EAGER))
	})
	Employee selectById(Integer employee_id);
	
	
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="updateEmployee")
	void update(Employee employee);

}
