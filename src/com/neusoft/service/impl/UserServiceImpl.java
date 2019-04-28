package com.neusoft.service.impl;
import  java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.dao.UserMapper;
import com.neusoft.pojo.User;
import com.neusoft.service.UserService;
import com.neusoft.util.tag.PageModel;
@Service("userService")
public class UserServiceImpl implements  UserService{
	@Autowired
	private  UserMapper  mapper;
	//��ѯ�û�������е�¼��֤
		public  User   querypwd(String user_loginname,String user_password)
		{
			return  mapper.queryuserpwd(user_loginname,user_password);
		}
		
		//�����û�id��ѯ�û���Ϣ
		
		public  User queryuserById(Integer user_id)
		{
			return  mapper.selectuserById(user_id);
		}
		
		//�����û���¼����ѯ�û�
		
		public  User  queryuserByName(String user_loginname)

		{
			
			return  mapper.selectuserByName(user_loginname);
			
		}
		
		
		@Transactional(readOnly=true)
		@Override
		//ģ����ѯ�û���Ϣ
		public List<User>  findUser(User user,PageModel  pageModel)
		{
			//��ǰ��Ҫ��ҳ������������
			
			Map<String,Object>  params= new  HashMap<> ();
			params.put("user",user);
			int recordCount = mapper.count(params);
			System.out.println("recordCount-->"+recordCount);
			pageModel.setRecordCount(recordCount);
			if(recordCount>0)
			{
				//��ʼ��ҳ��ѯ���ݣ���ѯ�ڼ�ҳ����
				
				params.put("pageModel",pageModel);
			}
			
			List<User>  users =mapper.selectuserbyPage(params);
			return users;
			
		}
		@Override
		public  void  insertUser(User user)
		{
			mapper.saveuser(user);
		}
    //�����û�idɾ���û�
		
		public  void  removeuser(Integer  user_id)
		{
			mapper.deleteuserById(user_id);
			
		}
		
		//��̬�����û���Ϣ
		
		public  void  modifyuser(User  user)
		{
			mapper.Updateuser(user);
		}
		
		//ע���û�
		
		public void zhuCe(User user)
		{
			mapper.Zhuceuser(user);	
		}
}








