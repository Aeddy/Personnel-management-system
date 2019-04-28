package com.neusoft.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.DocumentMapper;
import com.neusoft.pojo.Document;
import com.neusoft.service.DocumentService;
import com.neusoft.util.tag.PageModel;
@Service
public class DocumentServiceImpl implements DocumentService{
	@Autowired
	private  DocumentMapper   mapper;
	public  List<Document> selectDocumentbypage(Document  document,PageModel  pageModel)
	{
		
		Map<String,Object> params =new  HashMap<>();
		params.put("document", document);
		int  recordCount=mapper.count(params);
		pageModel.setRecordCount(recordCount);
		System.out.println("recordCount-->"+recordCount);
		if(recordCount>0)
		{
			params.put("pageModel", pageModel);
		}
		List<Document>  documents=mapper.querydocuemntbypage(params);
		return  documents;
		
	}

	public  Document  selectDocumentbyid(Integer  document_id)
	{
		return  mapper.querydocumentbyid(document_id);
	}

	public  List<Document> findAllDocument()
	{
		return mapper.selectAlldocument();
	}

	public  void  insertDocument(Document  document)
	{
		mapper.insertdocument(document);
	}

	public  void  updateDocument(Document  document)
	{
		mapper.updatedocument(document);
	}
	public  void  deleteDocument(Integer  document_id)
	
	{
		mapper.deletedocument(document_id);
	}
}
