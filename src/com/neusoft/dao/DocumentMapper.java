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
//�����ļ�id��ѯ�ĵ���Ϣ
	@Select("select  *  from  "+DOCUMENTTABLE+"  where  document_id=#{document_id}")
	public Document  querydocumentbyid(Integer document_id);
	
	//��ѯ�����ĵ�����Ϣ
	@Select("select *  from  "+DOCUMENTTABLE+" ")
    public List<Document> selectAlldocument();
	
	//��̬ģ����ѯ
	
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		
		@Result(id=true,column="document_id",property="document_id"),
		@Result(column="document_createdate",property="document_createdate",javaType=java.util.Date.class),
		@Result(column="user_id",property="user",
				one=@One(select="com.neusoft.dao.UserMapper.selectuserById",
				fetchType=FetchType.EAGER))
	})
	public  List<Document>  querydocuemntbypage(Map<String,Object> params);
	
	//��̬ͳ��������
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="count")
	public  Integer  count(Map<String,Object>  params);
	
	//����idɾ���ĵ���Ϣ�ļ���Ϣ
	
	@Delete("delete  from  "+DOCUMENTTABLE+" where  document_id=#{document_id}")
	public  void  deletedocument(Integer  document_id);
	
	//��̬�����ļ�
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="insertdocument")
	public  void  insertdocument(Document  document);
	
	//��̬�����ļ�
	
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="updatedocument")
	
	public  void  updatedocument(Document  document);
	
	
	
}
