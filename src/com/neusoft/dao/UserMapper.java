package com.neusoft.dao;
import static com.neusoft.util.common.HrmConstants.USERTABLE;

import java.util.Map;
import  java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.neusoft.dao.provider.UserDynaSqlProvider;
import com.neusoft.pojo.User;
public interface UserMapper {
	//���ݲ�ѯ�û�������е�¼��֤
	@Select("select *  from "+USERTABLE+" where  user_loginname=#{user_loginname} and user_password=#{user_password}")
 public  User  queryuserpwd(@Param("user_loginname")String  user_loginname,@Param("user_password")String user_password);
 //����id��ѯ�û�
 @Select("select *  from  "+USERTABLE+" where  user_id = #{user_id}")
 public  User  selectuserById(@Param("user_id") Integer  user_id);
 //�����û�����ѯ�û�
 @Select("select  *  from  "+USERTABLE+"  where  user_loginname=#{user_loginname}")
 public  User  selectuserByName(@Param("user_loginname")String  user_loginname);
 //�����û�idɾ���û�
 @Delete("delete from  "+USERTABLE+"  where  user_id=#{user_id}")
 public void  deleteuserById(@Param("user_id")  Integer user_id);
 //��̬�޸ĸ����û�
 @SelectProvider(type=UserDynaSqlProvider.class,method="updateuser")
 public void Updateuser(User user);
 //��̬��ҳ��ѯ�û�
 @SelectProvider(type=UserDynaSqlProvider.class,method="selectWhitParam")
 public  List<User>  selectuserbyPage(Map<String,Object>  params);
 //���ݲ�����ѯ�û�����
 @SelectProvider(type=UserDynaSqlProvider.class,method="count")
public Integer  count(Map<String , Object> params);
 //��̬�����û�
 @SelectProvider(type=UserDynaSqlProvider.class,method="insertuser") 
 public  void  saveuser(User user);
//�û�ע��
@SelectProvider(type=UserDynaSqlProvider.class,method="zhuceuser")
public void Zhuceuser(User user);
}
