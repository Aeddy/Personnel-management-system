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

import static com.neusoft.util.common.HrmConstants.DOCUMENTTABLE;

import com.neusoft.dao.provider.DocumentDynaSqlProvider;
import com.neusoft.pojo.Document;

public interface DocumentMapper {
//根据文件id查询文档信息
	@Select("select  *  from  "+DOCUMENTTABLE+"  where  document_id=#{document_id}")
	public Document  querydocumentbyid(Integer document_id);
	
	//查询所有文档的信息
	@Select("select *  from  "+DOCUMENTTABLE+" ")
    public List<Document> selectAlldocument();
	
	//动态模糊查询
	
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		
		@Result(id=true,column="document_id",property="document_id"),
		@Result(column="document_createdate",property="document_createdate",javaType=java.util.Date.class),
		@Result(column="user_id",property="user",
				one=@One(select="com.neusoft.dao.UserMapper.selectuserById",
				fetchType=FetchType.EAGER))
	})
	public  List<Document>  querydocuemntbypage(Map<String,Object> params);
	
	//动态统计数据量
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="count")
	public  Integer  count(Map<String,Object>  params);
	
	//根据id删除文档信息文件信息
	
	@Delete("delete  from  "+DOCUMENTTABLE+" where  document_id=#{document_id}")
	public  void  deletedocument(Integer  document_id);
	
	//动态插入文件
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="insertdocument")
	public  void  insertdocument(Document  document);
	
	//动态更新文件
	
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="updatedocument")
	
	public  void  updatedocument(Document  document);
	
	
	
}
