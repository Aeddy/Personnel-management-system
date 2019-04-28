package com.neusoft.dao;

import java.util.List;
import java.util.Map;
import  static  com.neusoft.util.common.HrmConstants.NOTICETABLE;
import com.neusoft.dao.provider.NoticeDynaSqlProvider;
import  com.neusoft.pojo.Notice;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

public interface NoticeMapper {
@SelectProvider(type=NoticeDynaSqlProvider.class,method="selectWhitParam")
@Results({
	
	@Result(id=true,column="notice_id",property="notice_id"),
	@Result(column="notice_createdate",property="notice_createdate",javaType=java.util.Date.class),
	@Result(column="user_id",property="user",
			one=@One(select="com.neusoft.dao.UserMapper.selectuserById",
			fetchType=FetchType.EAGER))
})

public  List<Notice>  selectByPage(Map<String,Object>  params);
@Delete("delete  from "+NOTICETABLE+"  where  notice_id=#{notice_id}")
public  void  deletenotice(Integer  notice_id);


@SelectProvider(type=NoticeDynaSqlProvider.class,method="count")
public  Integer  count(Map<String ,Object> params);

@SelectProvider(type=NoticeDynaSqlProvider.class,method="insertnotice")
public  void  insertnotice(Notice  notice);

@SelectProvider(type=NoticeDynaSqlProvider.class,method="updatenotice")
public  void  updatenotice(Notice notice);

@Select("select * from "+NOTICETABLE+" where  notice_id=#{notice_id}")
public  Notice  selectnoticeById(Integer  notice_id);


@Select("select * from  "+NOTICETABLE+" ")
public  List<Notice>  selectAllNotice();
}
