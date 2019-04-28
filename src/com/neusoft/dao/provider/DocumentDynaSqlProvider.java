package com.neusoft.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.neusoft.pojo.Document;

import  static  com.neusoft.util.common.HrmConstants.DOCUMENTTABLE;
public class DocumentDynaSqlProvider {
	
	//¶¯Ì¬²éÑ¯sql
	public String   selectWhitParam(Map<String,Object>  params)
	{
		String  sql=new SQL(){
			{
				SELECT("*");
				FROM(DOCUMENTTABLE);
				if(params.get("document")!=null)
				{
					Document document=(Document)params.get("document");
					if(document.getDocument_title()!=null&&!document.getDocument_title().equals(""))
					{
						WHERE("document_title LIKE  CONCAT ('%',#{document.document_title},'%')");
					}
				}
			}
		}.toString();
		if(params.get("pageModel")!=null)
		{
			sql=sql+" limit #{pageModel.firstLimitParam},#{pageModel.pageSize} ";
		}
		return sql;
	}
	
	public  String  count(Map<String,Object> params)
	{
		return  new SQL(){
			{
				SELECT("count(*)");
				FROM(DOCUMENTTABLE);
				if(params.get("document")!=null)
				{
					Document document=(Document)params.get("document");
					if(document.getDocument_title()!=null&&!document.getDocument_title().equals(""))
					{
						WHERE("document_title LIKE  CONCAT ('%',#{document.document_title},'%')");
					}
				}
			}
			}.toString();
			
			
	}
	public  String   insertdocument(Document  document)
	{
		return  new  SQL(){
			{
				INSERT_INTO(DOCUMENTTABLE);
				if(document.getDocument_title()!=null&&!document.getDocument_title().equals(""))
				{
					VALUES("document_title","#{document_title}");
				}
				if(document.getRemark()!=null&&!document.getRemark().equals(""))
				{
					VALUES("remark","#{remark}");
				}
				if(document.getFilename()!=null&&!document.getFilename().equals(""))
				{
					VALUES("filename","#{filename}");
				}
				if(document.getUser()!=null&&document.getUser().getUser_id()!=null)
				{
					VALUES("user_id","#{user.user_id}");
				}
			}
		}.toString();
	}
	public  String   updatedocument(Document  document)
	{
		return  new  SQL(){
			{
			    UPDATE(DOCUMENTTABLE);
				if(document.getDocument_title()!=null&&!document.getDocument_title().equals(""))
				{
					SET("document_title=#{document_title}");
				}
				if(document.getRemark()!=null&&!document.getRemark().equals(""))
				{
					SET("remark=#{remark}");
				}
				if(document.getFilename()!=null&&!document.getFilename().equals(""))
				{
					SET("filename=#{filename}");
				}
				if(document.getUser()!=null&&!document.getUser().equals(""))
				{
					SET("user_id=#{user.user_id}");
				}
			}
		}.toString();
	}
}
