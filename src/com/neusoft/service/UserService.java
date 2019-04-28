package com.neusoft.service;

import java.util.List;

import com.neusoft.pojo.User;
import com.neusoft.util.tag.PageModel;

public interface UserService {
	//��ѯ�û�������е�¼��֤
	public  User   querypwd(String user_loginname,String user_password);
	
	//�����û�id��ѯ�û���Ϣ
	
	public  User queryuserById(Integer user_id);
	
	//�����û�����ѯ�û�
	
	public  User  queryuserByName(String  user_loginname);
	
	//ģ����ѯ�û���Ϣ
	public  List<User>  findUser(User user,PageModel pageModel);
	
	//��̬����û���Ϣ
	public  void  insertUser(User  user);
	
	//�����û�idɾ������û�
	
	public  void  removeuser(Integer  user_id);
	
	//��̬�����û�
	
	public   void  modifyuser(User user);
	
	//ע���û�
	
	public void zhuCe(User user);
	
}
