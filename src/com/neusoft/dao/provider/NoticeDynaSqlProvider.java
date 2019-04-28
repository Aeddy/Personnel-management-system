package com.neusoft.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.neusoft.pojo.Notice;

import  static  com.neusoft.util.common.HrmConstants.NOTICETABLE;

import java.util.Map;
public class NoticeDynaSqlProvider {

	
	public  String  selectWhitParam(Map<String,Object>  params)
	{
		String sql=new  SQL(){
		{
			SELECT("*");
			FROM(NOTICETABLE);
			
			if(params.get("notice")!=null)
			{
				Notice  notice= (Notice)params.get("notice");
				
				if(notice.getNotice_content()!=null&&!notice.getNotice_content().equals(""))
				{
					WHERE(" notice_content  LIKE  CONCAT ('%',#{notice.notice_content},'%') ");
				}
				if(notice.getNotice_title()!=null&&!notice.getNotice_title().equals(""))
				{
					
					WHERE(" notice_title LIKE  CONCAT ('%',#{notice.notice_title},'%') ");
				}
			}
			
		}
		}.toString();
		if(params.get("pageModel")!=null)
		{
			sql=sql + " limit #{pageModel.firstLimitParam},#{pageModel.pageSize} ";
		}
		return sql;
	}
	
	public  String  insertnotice(Notice  notice)
	{
		return  new SQL(){
			{
				INSERT_INTO(NOTICETABLE);
				if(notice.getNotice_content()!=null&&!notice.getNotice_content().equals(""))
				{
					VALUES("notice_content","#{notice_content}");
				}
				if(notice.getNotice_title()!=null&&!notice.getNotice_title().equals(""))
				{
					VALUES("notice_title","#{notice_title}");
					
				}
				if(notice.getUser()!=null&&notice.getUser().getUser_id()!=null)
				{
					VALUES("user_id","#{user.user_id}");
				}
			}
		}.toString();
			
	}
	
	public  String  updatenotice(Notice  notice)
	{
		return new  SQL(){
			{
				UPDATE(NOTICETABLE);
				if(notice.getNotice_content()!=null)
				{
					SET("notice_content=#{notice_content}");
				}
				if(notice.getNotice_title()!=null)
				{
					SET("notice_title=#{notice_title}");
				}
				if(notice.getNotice_createdate()!=null)
				{
					SET("notice_createdate=#{notice_createdate}");
				}
				WHERE("notice_id=#{notice_id}");
			}
		}.toString();			
	}
	public  String  count(Map<String,Object> params)
	{
		return  new  SQL(){
			{
				SELECT("count(*)");
				FROM(NOTICETABLE);
				if(params.get("notice")!=null)
				{
					Notice  notice= (Notice)params.get("notice");
					
					if(notice.getNotice_content()!=null&&!notice.getNotice_content().equals(""))
					{
						WHERE(" notice_content  LIKE  CONCAT ('%',#{notice.notice_content},'%') ");
					}
					if(notice.getNotice_title()!=null&&!notice.getNotice_title().equals(""))
					{
						
						WHERE(" notice_title LIKE  CONCAT ('%',#{notice.notice_title},'%') ");
					}
				}
				
			}
		}.toString();
	}
	
}
