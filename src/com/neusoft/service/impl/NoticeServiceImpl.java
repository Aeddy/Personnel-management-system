package com.neusoft.service.impl;

import java.util.HashMap;
import  java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.neusoft.dao.NoticeMapper;
import com.neusoft.pojo.Notice;
import com.neusoft.service.NoticeService;
import com.neusoft.util.tag.PageModel;
@Service("noticeService")
public class NoticeServiceImpl implements  NoticeService{
	@Autowired
	private  NoticeMapper  mapper;
	@Transactional(readOnly=true)
	@Override
	public  List<Notice> selectnotice(Notice notice,PageModel pageModel)
	{
		Map<String , Object>  params  =new  HashMap<>();
		params.put("notice", notice);
		int recordCount=mapper.count(params);
		System.out.println("recordCount-->"+recordCount);
		pageModel.setRecordCount(recordCount);
		if(recordCount>0)
		{
			params.put("pageModel", pageModel);
		}
		List<Notice> notices=mapper.selectByPage(params);
		return notices;
	}

	public  List<Notice> findAllnotice()
	{
		return mapper.selectAllNotice();
	}

	public  void  addnotice(Notice  notice)
	{
		mapper.insertnotice(notice);
	}

	public  void   medify(Notice notice)
	{
		mapper.updatenotice(notice);
	}

	public   Notice  findnoticebyid(Integer  notice_id)
	{
		return  mapper.selectnoticeById(notice_id);
	}
	public  void  removenotice(Integer  notice_id)
	{
	mapper.deletenotice(notice_id);
	}
}
