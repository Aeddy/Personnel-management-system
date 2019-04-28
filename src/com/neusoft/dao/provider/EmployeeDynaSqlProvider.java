package com.neusoft.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import com.neusoft.pojo.Employee;
import static com.neusoft.util.common.HrmConstants.EMPLOYEETABLE;



public class EmployeeDynaSqlProvider {
	
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(EMPLOYEETABLE);
				if(params.get("employee") != null){
					Employee employee = (Employee)params.get("employee");
					if(employee.getDept() != null && employee.getDept().getDept_id() != null && employee.getDept().getDept_id() != 0){
						WHERE(" dept_id= #{employee.dept.dept_id} ");
					}
					if(employee.getJob() != null && employee.getJob().getJob_id() != null && employee.getJob().getJob_id() != 0){
						WHERE(" job_id = #{employee.job.job_id} ");
					}
					if(employee.getEmployee_name() != null && !employee.getEmployee_name().equals("")){
						WHERE("  employee_name LIKE CONCAT ('%',#{employee.employee_name},'%') ");
					}
					if(employee.getEmployee_phone() != null && !employee.getEmployee_phone().equals("")){
						WHERE(" employee_phone LIKE CONCAT ('%',#{employee.employee_phone},'%') ");
					}
					if(employee.getCard_id() != null && !employee.getCard_id().equals("") ){
						WHERE(" card_id LIKE CONCAT ('%',#{employee.card_id},'%') ");
					}
					if(employee.getEmployee_sex()!= null && employee.getEmployee_sex() != 0){
						WHERE("employee_sex = #{employee.employee_sex}");
					}
				}
			}
		}.toString();
		
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		
		return sql;
	}	
	
	public String count(Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(EMPLOYEETABLE);
				if(params.get("employee") != null){
					Employee employee = (Employee)params.get("employee");
					if(employee.getDept() != null && employee.getDept().getDept_id() != null && employee.getDept().getDept_id() != 0){
						WHERE(" dept_id = #{employee.dept.dept_id} ");
					}
					if(employee.getJob() != null && employee.getJob().getJob_id() != null && employee.getJob().getJob_id() != 0){
						WHERE(" job_id = #{employee.job.job_id} ");
					}
					if(employee.getEmployee_name() != null && !employee.getEmployee_name().equals("")){
						WHERE("  employee_name LIKE CONCAT ('%',#{employee.employee_name},'%') ");
					}
					if(employee.getEmployee_phone() != null && !employee.getEmployee_phone().equals("")){
						WHERE(" employee_phone LIKE CONCAT ('%',#{employee.employee_phone},'%') ");
					}
					if(employee.getCard_id() != null && !employee.getCard_id().equals("") ){
						WHERE(" card_id LIKE CONCAT ('%',#{employee.card_id},'%') ");
					}
					if(employee.getEmployee_sex()!= null && employee.getEmployee_sex() != 0){
						WHERE("employee_sex = #{employee.employee_sex}");
					}
				}
			}
		}.toString();
	}	
	
	
	public String insertEmployee(Employee employee){
		
		return new SQL(){
			{
				INSERT_INTO(EMPLOYEETABLE);
				if(employee.getEmployee_name() != null){
					VALUES("employee_name", "#{employee_name}");
				}
				if(employee.getCard_id() != null){
					VALUES("card_id", "#{card_id}");
				}
				if(employee.getEmployee_address()!= null){
					VALUES("employee_address", "#{employee_address}");
				}
				if(employee.getEmployee_postcode()!= null){
					VALUES("employee_postcode", "#{employee_postcode}");
				}
				if(employee.getEmployee_tel()!= null){
					VALUES("employee_tel", "#{employee_tel}");
				}
				if(employee.getEmployee_phone()!= null){
					VALUES("employee_phone", "#{employee_phone}");
				}
				if(employee.getEmployee_qqnum()!= null){
					VALUES("employee_qqnum", "#{employee_qqnum}");
				}
				if(employee.getEmployee_email()!= null){
					VALUES("employee_email", "#{employee_email}");
				}
				if(employee.getEmployee_sex()!= null){
					VALUES("employee_sex", "#{employee_sex}");
				}
				if(employee.getEmployee_party()!= null){
					VALUES("employee_party", "#{employee_party}");
				}
				if(employee.getEmployee_birthday()!= null){
					VALUES("employee_birthday", "#{employee_birthday}");
				}
				if(employee.getEmployee_race()!= null){
					VALUES("employee_race", "#{employee_race}");
				}
				if(employee.getEmployee_education()!= null){
					VALUES("employee_education", "#{employee_education}");
				}
				if(employee.getEmployee_speciality()!= null){
					VALUES("employee_speciality", "#{employee_speciality}");
				}
				if(employee.getEmployee_hobby()!= null){
					VALUES("employee_hobby", "#{employee_hobby}");
				}
				if(employee.getEmployee_remark()!= null){
					VALUES("employee_remark", "#{employee_remark}");
				}
				if(employee.getEmployee_createdate()!= null){
					VALUES("employee_createdate", "#{employee_createdate}");
				}
				if(employee.getDept()!= null){
					VALUES("dept_id", "#{dept.dept_id}");
				}
				if(employee.getJob()!= null){
					VALUES("job_id", "#{job.job_id}");
				}
			}
		}.toString();
	}
	
	public String updateEmployee(Employee employee){
		
		return new SQL(){
			{
				UPDATE(EMPLOYEETABLE);
				if(employee.getEmployee_name() != null){
					SET(" employee_name = #{employee_name} ");
				}
				if(employee.getCard_id() != null){
					SET(" card_id = #{card_id} ");
				}
				if(employee.getEmployee_address()!= null){
					SET(" employee_address = #{employee_address} ");
				}
				if(employee.getEmployee_postcode()!= null){
					SET(" employee_postcode = #{employee_postcode} ");
				}
				if(employee.getEmployee_tel()!= null){
					SET(" employee_tel = #{employee_tel} ");
				}
				if(employee.getEmployee_phone()!= null){
					SET(" employee_phone = #{employee_phone} ");
				}
				if(employee.getEmployee_qqnum()!= null){
					SET(" employee_qqnum = #{employee_qqnum} ");
				}
				if(employee.getEmployee_email()!= null){
					SET(" employee_email = #{employee_email} ");
				}
				if(employee.getEmployee_sex()!= null){
					SET(" employee_sex = #{employee_sex} ");
				}
				if(employee.getEmployee_party()!= null){
					SET("employee_party = #{employee_party} ");
				}
				if(employee.getEmployee_birthday()!= null){
					SET(" employee_birthday = #{employee_birthday} ");
				}
				if(employee.getEmployee_race()!= null){
					SET(" employee_race = #{employee_race} ");
				}
				if(employee.getEmployee_education()!= null){
					SET(" employee_education = #{employee_education} ");
				}
				if(employee.getEmployee_speciality()!= null){
					SET(" employee_speciality = #{employee_speciality} ");
				}
				if(employee.getEmployee_hobby()!= null){
					SET(" employee_hobby = #{employee_hobby} ");
				}
				if(employee.getEmployee_remark()!= null){
					SET(" employee_remark = #{employee_remark} ");
				}
				if(employee.getEmployee_createdate()!= null){
					SET(" employee_createdate = #{employee_createdate} ");
				}
				if(employee.getDept()!= null){
					SET(" dept_id = #{dept.dept_id} ");
				}
				if(employee.getJob()!= null){
					SET(" job_id = #{job.job_id} ");
				}
				WHERE(" employee_id = #{employee_id} ");
			}
		}.toString();
	}


}
