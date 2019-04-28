package com.neusoft.dao.provider;
import  static  com.neusoft.util.common.HrmConstants.DEPTTABLE;
import static com.neusoft.util.common.HrmConstants.USERTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.neusoft.pojo.Dept;
import com.neusoft.pojo.User;

public class DeptDynaSqlProvider {
	
	
	public  String   selectWhitParam(Map<String ,Object>  params)
	{
		String   sql=new  SQL(){
			{
				SELECT("*");
				FROM(DEPTTABLE);
				if(params.get("dept")!=null)
				{
					Dept  dept=(Dept)params.get("dept");
					if(dept.getDept_name()!=null&&!dept.getDept_name().equals(""))
					{
						WHERE("dept_name LIKE  CONCAT ('%',#{dept.dept_name},'%')");
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
	    FROM(DEPTTABLE);
	    if(params.get("dept")!=null)
	    {
	    	Dept  dept=(Dept)params.get("dept");
	    	if(dept.getDept_name()!=null&&!dept.getDept_name().equals(""))
	    	{
	    		WHERE("dept_name LIKE CONCAT('%',#{dept.dept_name},'%')");
	    	}
	    	
	    }
	
	}
	}.toString();
}
public String updatedept(Dept dept){
	
	return new SQL(){
		{
			UPDATE(DEPTTABLE);
			if(dept.getDept_name() != null){
				SET(" dept_name = #{dept_name} ");
			}
			if(dept.getDept_remark() != null){
				SET(" dept_remark = #{dept_remark} ");
			}
			
			WHERE(" dept_id = #{dept_id} ");
		}
	}.toString();
}
public  String   insertdept(Dept  dept)
{
	return new SQL(){
	{
		INSERT_INTO(DEPTTABLE);
		if(dept.getDept_name()!=null&&!dept.getDept_name().equals(""))
		{
			VALUES("dept_name","#{dept_name}");
		}
		if(dept.getDept_remark()!=null&&!dept.getDept_remark().equals(""))
		{
			VALUES("dept_remark","#{dept_remark}");
		}
	}
	}.toString();
			
}















}
