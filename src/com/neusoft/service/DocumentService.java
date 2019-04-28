package com.neusoft.service;

import java.util.List;

import com.neusoft.pojo.Document;
import com.neusoft.util.tag.PageModel;

public interface DocumentService {
public  List<Document> selectDocumentbypage(Document  document,PageModel  pageModel);

public  Document  selectDocumentbyid(Integer  document_id);

public  List<Document> findAllDocument();

public  void  insertDocument(Document  document);

public  void  updateDocument(Document  document);

public   void  deleteDocument(Integer document_id);
}
