package com.neusoft.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import static  com.neusoft.util.common.HrmConstants.USER_SESSION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neusoft.pojo.Notice;
import com.neusoft.pojo.User;
import com.neusoft.service.NoticeService;
import com.neusoft.util.common.HrmConstants;
import com.neusoft.util.tag.PageModel;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private  NoticeService noticeService;
	
	@RequestMapping("/selectNotice")
	//分页查询公告信息
	public  ModelAndView  selectNotice(Integer pageIndex,@ModelAttribute Notice notice,ModelAndView  mv)
	{
		PageModel  pageModel=new PageModel();
		
		if(pageIndex!=null)
		{
			pageModel.setPageIndex(pageIndex);
			
		}
		List<Notice> notices=noticeService.selectnotice(notice, pageModel);
		mv.addObject("notices",notices);
		mv.addObject("pageModel",pageModel);
		mv.setViewName("noticemessage");
		return mv;
	}
@RequestMapping("/addNotice")
//添加公告信息
public  ModelAndView  addNotice(Notice  notice,String flag,ModelAndView mv,HttpSession  session)
{
	if(flag.equals("1"))
	{
		mv.setViewName("showAddNotice");
	}else{
		User user=(User)session.getAttribute(HrmConstants.USER_SESSION);
		notice.setUser(user);
		noticeService.addnotice(notice);
		mv.setViewName("redirect:/notice/selectNotice.action");
	}
	return mv;
	
}
@RequestMapping("/removeNotice")
//移除公告信息
public  ModelAndView  removeNotice(String  ids,ModelAndView  mv)
{
	String  idsarray[]=ids.split(",");
	for(String  notice_id:idsarray){
	noticeService.removenotice(Integer.parseInt(notice_id));
	}
	mv.setViewName("redirect:/notice/selectNotice.action");
	return mv;
}
@RequestMapping("/updateNotice")
//修改更新公告信息
public  ModelAndView  updateNotice(@ModelAttribute  Notice  notice,String flag,ModelAndView  mv)
{
	if(flag.equals("1"))
	{
		Notice  target=noticeService.findnoticebyid(notice.getNotice_id());
		mv.addObject("notice",target);
		mv.setViewName("showUpdateNotice");
	}else{
		noticeService.medify(notice);
		
		mv.setViewName("redirect:/notice/selectNotice.action");
	}
	return mv;
}
@RequestMapping("/previewNotice")
//上传公告
public  ModelAndView   previewNotice(ModelAndView  mv,Integer  notice_id)
{
	Notice  notice=noticeService.findnoticebyid(notice_id);
	mv.addObject("notice",notice);
	mv.setViewName("previewNotice");
	return mv;
}
}
