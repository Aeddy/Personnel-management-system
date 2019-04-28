<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登录页面</title>
</head> 
<body style="background-image: url(../images/main.jpg);background-repeat: no-repeat;-webkit-background-size: cover;
    -moz-background-size: cover; -o-background-size: cover; background-size: cover;"> 
    <center>
    	<h1 class="w3ls-title w3ls-title1">User Login</h1> 
    	<div class="login-body">
    	<font color="red">  ${error} </font>
				<form action="<%=pageContext.getServletContext().getContextPath() %>/user/login.action">

		<table border="1">
			<tr>

				<td>用户名</td>

				<td><input type="text" name="user_loginname"></td>

			</tr>

			<tr>

				<td>密码</td>

				<td><input type="text" name="user_password"></td>

			</tr>

			<tr>

				<td><input type="submit" value="登录"></td>

			</tr>

		</table>
		</form>
		<br>
<h1><a href="<%=pageContext.getServletContext().getContextPath() %>/jsp/regist.jsp">没有账号吗？点击这里，注册一个吧</a></h1>		

	
			</div> 
			<div>
				<img src="../images/product.jpg" />
			</div>
    </center>
</body> 
</html> 