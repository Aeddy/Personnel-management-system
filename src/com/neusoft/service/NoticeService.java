package com.neusoft.service;

import java.util.List;

import com.neusoft.pojo.Notice;
import com.neusoft.util.tag.PageModel;

public interface NoticeService {
public  List<Notice> selectnotice(Notice notice,PageModel pageModel);

public  List<Notice> findAllnotice();

public  void  addnotice(Notice  notice);

public  void   medify(Notice notice);

public   Notice  findnoticebyid(Integer  notice_id);

public  void  removenotice(Integer  notice_id);
}
