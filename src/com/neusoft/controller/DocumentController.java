package com.neusoft.controller;

import java.io.File;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neusoft.pojo.Document;

import com.neusoft.pojo.User;
import com.neusoft.service.DocumentService;

import com.neusoft.util.common.HrmConstants;
import com.neusoft.util.tag.PageModel;

@Controller
@RequestMapping("/document")
public class DocumentController {
	@Autowired
	private  DocumentService documentService;
	//分页查询下载文件
	@RequestMapping("/selectDocument")
	public  ModelAndView  selectDocument(Integer pageIndex,@ModelAttribute Document document,ModelAndView  mv)
	{
		PageModel  pageModel=new PageModel();
		
		if(pageIndex!=null)
		{
			pageModel.setPageIndex(pageIndex);
			
		}
		List<Document> documents=documentService.selectDocumentbypage(document, pageModel);
		mv.addObject("documents",documents);
		mv.addObject("pageModel",pageModel);
		mv.setViewName("documentmessage");
		return mv;
	}
@RequestMapping("/addDocument")
//添加下载文件
public  ModelAndView  addDocumentg(Document  document,String flag,ModelAndView mv,HttpSession  session) 
		throws Exception
{
	if(flag.equals("1"))
	{
		mv.setViewName("showAddDocument");
	}else{
		//上传文件路径
		String path=session.getServletContext().getRealPath("/upload/");
		// 上传文件名
		String  filename=document.getFile().getOriginalFilename();
		//将上传文件保存在一个目标文件夹中
		document.getFile().transferTo(new  File(path+File.separator+ filename));
		document.setFilename(filename);
		User user=(User)session.getAttribute(HrmConstants.USER_SESSION);
		document.setUser(user);
		documentService.insertDocument(document);
		mv.setViewName("redirect:/document/selectDocument.action");
	}
	return mv;
	
}
@RequestMapping("/removeDocument")
//移除下载文件
public  ModelAndView  removeDocument(String  ids,ModelAndView  mv)
{
	String  idsarray[]=ids.split(",");
	for(String  document_id:idsarray){
	documentService.deleteDocument(Integer.parseInt(document_id));
	}
	mv.setViewName("redirect:/document/selectDocument.action");
	return mv;
}
@RequestMapping("/updateDocument")
//修改更新下载文件
public  ModelAndView  updateDocument(@ModelAttribute  Document  document,String flag,ModelAndView  mv)
{
	if(flag.equals("1"))
	{
		Document  target=documentService.selectDocumentbyid(document.getDocument_id());
		mv.addObject("document",target);
		mv.setViewName("showUpdateDocument");
	}else{
		documentService.updateDocument(document);
		
		mv.setViewName("redirect:/document/selectDocument.action");
	}
	return mv;
}
@RequestMapping("/previewDocument")
//上传文件
public  ModelAndView   previewDocument(ModelAndView  mv,Integer  document_id)
{
	Document  document=documentService.selectDocumentbyid(document_id);
	mv.addObject("document",document);
	mv.setViewName("previewDocument");
	return mv;
}
@RequestMapping("/downLoad")
//下载文件
public  ResponseEntity<byte[]>  downLoad(Integer  document_id,HttpSession  session) 
		throws Exception{
	Document  target=documentService.selectDocumentbyid(document_id);
	String  filename=target.getFilename();
	//上传文件的路径
	String  path=session.getServletContext().getRealPath("/upload/");
	//获取子啊在文件的File对象
	File  file=new  File(path+File.separator+ filename);
	//创建springframework的HttpHeagders对象
	HttpHeaders  headers=new  HttpHeaders();
	//下载显示的文件名，解决中文名称乱码问题
	String  downloadFilename=new  String(filename.getBytes("UTF-8"),"iso-8859-1");
	//通知浏览器以attachment(下载方式）打开图片
	headers.setContentDispositionFormData("attachment", downloadFilename);
	//application/octet-stream:二进制流文件最常见的下载方式
	headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	//201  HttpStatus.CREATED
	return  new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	
	
}
}