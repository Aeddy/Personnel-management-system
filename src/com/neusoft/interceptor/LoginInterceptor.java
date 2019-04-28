package com.neusoft.interceptor;


	

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.web.servlet.HandlerInterceptor;
	import org.springframework.web.servlet.ModelAndView;

	public  class LoginInterceptor implements HandlerInterceptor{

		@Override
		public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
				throws Exception {
			// TODO Auto-generated method stub
			
		}

		
		@Override
		public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
			//�Ự�������Ƿ�洢��account������
			System.out.println("preHandle");
			String path = arg0.getRequestURI();
			if(path.endsWith("login.action")){
				return true;
			}
			else{
				HttpSession session = arg0.getSession();
				if(session.getAttribute("user")!=null){
					return true;
				}
				//�ñ������ʽ������ת
				arg0.setAttribute("error", "�����ȵ�¼");
				
				arg0.getRequestDispatcher("/jsp/loginForm.jsp").forward(arg0, arg1);
				return false;
			}
			
		}

		@Override
		public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
				throws Exception {
			// TODO Auto-generated method stub
			
		}

	}


