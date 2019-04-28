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
	//ģ����ѯְ��
	@SelectProvider(type=DeptDynaSqlProvider.class,method="selectWhitParam")
	public  List<Dept> selectByPage(Map<String,Object> params);
	
	//ģ����ѯͳ�Ʋ�����������
	@SelectProvider(type=DeptDynaSqlProvider.class,method="count")
	public  Integer  count(Map<String,Object> params);
	
	//��ѯ���в���
	@Select("select  *    from  "+DEPTTABLE+" ")
	public  List<Dept>  selectAllDept();
	
	
	//���ݲ���id��ѯ������Ϣ
	@Select("select  * from  "+DEPTTABLE+"  where  dept_id=#{dept_id}")
	public  Dept  selectdeptById(Integer  dept_id);
	
	//����idɾ��������Ϣ
	
	@Delete("delete  from  "+DEPTTABLE+"  where  dept_id=#{dept_id}" )
	public  void   deleteDeptById(@Param("dept_id")Integer  dept_id);
	
   //��̬���²�����Ϣ
	@SelectProvider(type=DeptDynaSqlProvider.class,method="updatedept")
	public  void   medifydept(Dept  dept);
	
	@SelectProvider(type=DeptDynaSqlProvider.class,method="insertdept") 
	 public  void  savedept(Dept  dept);
	
}
