<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户信息</title>
</head>
<body>
<center>
<h2 align="center">哈哈哈，查到该用户的信息了！！</h2>
<br>
<br>
<br>
<table border="1">
<tr>
<th>用户编号</th><th>用户登录名</th><th>用户密码</th><th>用户状态</th><th>用户创建时间</th><th>用户姓名</th>
</tr>
<tr>
<td>${sessionScope.user.user_id}</td><td>${sessionScope.user.user_loginname}</td>
<td>${sessionScope.user.user_password}</td><td>${sessionScope.user.user_status}</td>
<td>${sessionScope.user.user_createdate}</td><td>${sessionScope.user.user_name}</td>
</tr>
</table>
</center>
</html>