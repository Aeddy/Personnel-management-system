<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>人事管理系统——添加员工</title>
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
	<script language="javascript" type="text/javascript" src="<%=pageContext.getServletContext().getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	
	 
	    $(function(){
	    	/** 员工表单提交 */
			$("#employeeForm").submit(function(){
				alert("亲，正在添加员工信息ing");
				var employee_name = $("#employee_name");
				var card_id = $("#card_id");
				var employee_education = $("#employee_education");
				var employee_email = $("#employee_email");
				var employee_phone = $("#employee_phone");
				var employee_tel = $("#employee_tel");
				var employee_party = $("#employee_party");
				var employee_qqnum = $("#employee_qqnum");
				var employee_address = $("#employee_address");
				var employee_postcode = $("#employee_postcode");
				var employee_birthday = $("#employee_birthday");
				var employee_race = $("#employee_race");
				var employee_speciality = $("#employee_speciality");
				var employee_hobby = $("#employee_hobby");
				var msg = "";
				if ($.trim(employee_name.val()) == ""){
					msg = "姓名不能为空！";
					employee_name.focus();
				}else if ($.trim(card_id.val()) == ""){
					msg = "身份证号码不能为空！";
					card_id.focus();
				}else if (!/^[1-9]\d{16}[0-9A-Za-z]$/.test($.trim(card_id.val()))){
					msg = "身份证号码格式不正确！";
					card_id.focus();
				}else if ($.trim(employee_education.val()) == ""){
					msg = "学历不能为空！";
					employee_education.focus();
				}else if ($.trim(employee_email.val()) == ""){
					msg = "邮箱不能为空！";
					employee_email.focus();
				}else if (!/^\w+@\w{2,3}\.\w{2,6}$/.test($.trim(employee_email.val()))){
					msg = "邮箱格式不正确！";
					employee_email.focus();
				}else if ($.trim(employee_phone.val()) == ""){
					msg = "手机号码不能为空！";
					employee_phone.focus();
				}else if (!/^1[3|5|8]\d{9}$/.test($.trim(employee_phone.val()))){
					msg = "手机号码格式不正确！";
					employee_phone.focus();
				}else if ($.trim(employee_tel.val()) == ""){
					msg = "电话号码不能为空！";
					employee_tel.focus();
				}else if (!/^0\d{2,3}-?\d{7,8}$/.test($.trim(employee_tel.val()))){
					msg = "电话号码格式不正确！";
					employee_tel.focus();
				}else if ($.trim(employee_party.val()) == ""){
					msg = "政治面貌不能为空！";
					employee_party.focus();
				}else if ($.trim(employee_qqnum.val()) == ""){
					msg = "QQ号码不能为空！";
					employee_qqnum.focus();
				}else if (!/^\d{6,}$/.test($.trim(employee_qqnum.val()))){
					msg = "QQ号码格式不正确！";
					employee_qqnum.focus();
				}else if ($.trim(employee_address.val()) == ""){
					msg = "地址不能为空！";
					employee_address.focus();
				}else if ($.trim(employee_postcode.val()) == ""){
					msg = "邮政编码不能为空！";
					employee_postcode.focus();
				}else if (!/^[1-9]\d{5}$/.test($.trim(employee_postcode.val()))){
					msg = "邮政编码格式不正确！";
					employee_postcode.focus();
				}else if ($.trim(employee_birthday.val()) == ""){
					msg = "出生日期不能为空！";
					employee_birthday.focus();
				}else if (!employee_birthday.val()){
					!/^\d{4}-\d{2}-\d{2}$/.test($.trim(birthday.val()))
					msg = "出生日期格式不正确！";
					employee_birthday.focus();
				}else if ($.trim(employee_race.val()) == ""){
					msg = "民族不能为空！";
					employee_race.focus();
				}else if ($.trim(employee_speciality.val()) == ""){
					msg = "专业不能为空！";
					employee_speciality.focus();
				}else if ($.trimemployee_(hobby.val()) == ""){
					msg = "爱好不能为空！";
					employee_hobby.focus();
				}
				if (msg != ""){
					$.ligerDialog.error(msg);
					return false;
				}else{
					return true;
				}
				$("#employeeForm").submit();
			});
	    });
		

	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="<%=pageContext.getServletContext().getContextPath() %>/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="<%=pageContext.getServletContext().getContextPath() %>/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：员工管理  &gt; 添加员工</td>
	<td width="15" height="32"><img src="<%=pageContext.getServletContext().getContextPath() %>/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
    	 <form action="<%=pageContext.getServletContext().getContextPath() %>/employee/addEmployee.action" id="employeeForm" method="post">
		 	<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table>
		    		<tr>
		    			<td class="font3 fftd">姓名：<input type="text" name="employee_name" id="employee_name" size="20"/></td>
		    			<td class="font3 fftd">身份证号码：<input type="text" name="card_id" id="card_id" size="20"/></td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">性别：
									<select name="employee_sex" style="width:143px;">
					    			<option value="0">--请选择性别--</option>
					    			<option value="1">男</option>
					    			<option value="2">女</option>
					    		</select></td>
		    			<td class="font3 fftd">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位：
		    			 <select id="job_id" name="job.job_id" style="width:143px;">
					    			<option value="0">--请选择职位--</option>
					    			<c:forEach items="${requestScope.jobs }" var="job">
					    				<option value="${job.job_id }">${job.job_name }</option>
					    			</c:forEach>
					    		</select>
					    </td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">学历：<input name="employee_education" id="employee_education" size="20"/></td>
		    			<td class="font3 fftd">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：<input name="employee_email" id="employee_email" size="20"/></td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">手机：<input name="employee_phone" id="employee_phone" size="20"/></td>
		    			<td class="font3 fftd">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<input name="employee_tel" id="employee_tel" size="20"/></td>
		    		</tr>
		    		
		    	</table>
		    </td></tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					政治面貌：<input name="employee_party" id="employee_party" size="40"/>&nbsp;&nbsp;
					QQ&nbsp;&nbsp;号码：<input name="employee_qqnum" id="employee_qqnum" size="20"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					联系地址：<input name="employee_address" id="employee_address" size="40"/>&nbsp;&nbsp;
					邮政编码：<input name="employee_postcode" id="employee_postcode" size="20"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					出生日期：<input cssClass="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});"
					name="employee_birthday" id="employee_birthday" size="40"/>&nbsp;&nbsp;
					民&nbsp;&nbsp;&nbsp;&nbsp;族：<input name="employee_race" id="employee_race" size="20"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					所学专业：<input  name="employee_speciality" id="employee_speciality" size="40"/>&nbsp;&nbsp;
					爱&nbsp;&nbsp;&nbsp;&nbsp;好：<input name="employee_hobby" id="employee_hobby" size="20"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					备&nbsp;&nbsp;&nbsp;&nbsp;注：<input name="employee_remark" id="employee_remark" size="40"/>
					&nbsp;&nbsp;所属部门：
					<select  id="dept_id" name="dept.dept_id" style="width:100px;">
						   <option value="0">--部门选择--</option>
						   <c:forEach items="${requestScope.depts }" var="dept">
			    				<option value="${dept.dept_id }">${dept.dept_name }</option>
			    			</c:forEach>
					</select>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr><td align="left" class="fftd">
			<input type="submit" value="添加">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
<div style="height:10px;"></div>
</body>
</html>