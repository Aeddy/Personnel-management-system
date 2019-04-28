<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>人事管理系统——添加用户</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="<%=pageContext.getServletContext().getContextPath() %>/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="<%=pageContext.getServletContext().getContextPath() %>/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="<%=pageContext.getServletContext().getContextPath() %>/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath() %>/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath() %>/js/jquery-migrate-1.2.1.js"></script>
	<script src="<%=pageContext.getServletContext().getContextPath() %>/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="<%=pageContext.getServletContext().getContextPath() %>/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="<%=pageContext.getServletContext().getContextPath() %>/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="<%=pageContext.getServletContext().getContextPath() %>/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
	<link href="<%=pageContext.getServletContext().getContextPath() %>/css/pager.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript">
	
	$(function(){
    	/** 员工表单提交 */
		$("#userForm").submit(function(){
			alert("亲，正在添加用户ing");
			var user_name = $("#user_name");
			var user_status = $("#user_status");
			var user_loginname = $("#user_loginname");
			var user_password = $("#user_password");
			var msg = "";
			if ($.trim(user_name.val()) == ""){
				msg = "姓名不能为空！";
				user_name.focus();
			}else if ($.trim(user_status.val()) == ""){
				msg = "状态不能为空！";
				user_status.focus();
			}else if ($.trim(user_loginname.val()) == ""){
				msg = "登录名不能为空！";
				user_loginname.focus();
			}else if ($.trim(user_password.val()) == ""){
				msg = "密码不能为空！";
				user_password.focus();
			}
			if (msg != ""){
				$.ligerDialog.error(msg);
				return false;
			}else{
				return true;
			}
			$("#userForm").submit();
		});
    });
		

	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="<%=pageContext.getServletContext().getContextPath() %>/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="<%=pageContext.getServletContext().getContextPath() %>/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：用户管理  &gt; 添加用户</td>
	<td width="15" height="32"><img src="<%=pageContext.getServletContext().getContextPath() %>/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
    	 <form action="<%=pageContext.getServletContext().getContextPath() %>/user/addUser.action" id="userForm" method="post">
    	 	<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table>
		    		<tr>
		    			<td class="font3 fftd">姓&nbsp;名：<input type="text" name="user_name" id="user_name" size="20"/></td>
		    			<td class="font3 fftd">状&nbsp;态：<input type="text" name="user_status" id="user_status" size="20"/></td>
		    		</tr>
		    			
		    		<tr>
		    			<td class="font3 fftd">登录名：<input name="user_loginname" id="user_loginname" size="20" /></td>
		    			<td class="font3 fftd">密&nbsp;码：<input name="user_password" id="user_password" size="20" /></td>
		    		</tr>
		    		
		    	</table>
		    </td></tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr><td align="left" class="fftd"><input type="submit" value="添加">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
<div style="height:10px;"></div>
</body>
</html>