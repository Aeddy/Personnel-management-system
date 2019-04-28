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
	//根据查询用户密码进行登录验证
	@Select("select *  from "+USERTABLE+" where  user_loginname=#{user_loginname} and user_password=#{user_password}")
 public  User  queryuserpwd(@Param("user_loginname")String  user_loginname,@Param("user_password")String user_password);
 //根据id查询用户
 @Select("select *  from  "+USERTABLE+" where  user_id = #{user_id}")
 public  User  selectuserById(@Param("user_id") Integer  user_id);
 //根据用户名查询用户
 @Select("select  *  from  "+USERTABLE+"  where  user_loginname=#{user_loginname}")
 public  User  selectuserByName(@Param("user_loginname")String  user_loginname);
 //根据用户id删除用户
 @Delete("delete from  "+USERTABLE+"  where  user_id=#{user_id}")
 public void  deleteuserById(@Param("user_id")  Integer user_id);
 //动态修改更新用户
 @SelectProvider(type=UserDynaSqlProvider.class,method="updateuser")
 public void Updateuser(User user);
 //动态分页查询用户
 @SelectProvider(type=UserDynaSqlProvider.class,method="selectWhitParam")
 public  List<User>  selectuserbyPage(Map<String,Object>  params);
 //根据参数查询用户总数
 @SelectProvider(type=UserDynaSqlProvider.class,method="count")
public Integer  count(Map<String , Object> params);
 //动态插入用户
 @SelectProvider(type=UserDynaSqlProvider.class,method="insertuser") 
 public  void  saveuser(User user);
//用户注册
@SelectProvider(type=UserDynaSqlProvider.class,method="zhuceuser")
public void Zhuceuser(User user);
}
