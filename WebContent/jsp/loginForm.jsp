<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>人事管理系统</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<link href="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/plugins/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/css/style-metro.css" rel="stylesheet"
	type="text/css" />
<link href="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/css/style-responsive.css" rel="stylesheet"
	type="text/css" />
<link href="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/css/themes/default.css" rel="stylesheet"
	type="text/css" id="style_color" />
<link href="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/plugins/uniform/css/uniform.default.css"
	rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/css/pages/lock.css" rel="stylesheet"
	type="text/css" />
<!-- END PAGE LEVEL STYLES -->
<link rel="shortcut icon" href="favicon.ico" />
<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath() %>/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath() %>/js/jquery-migrate-1.2.1.js"></script>
<link href="<%=pageContext.getServletContext().getContextPath() %>/js/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />  
<script src="<%=pageContext.getServletContext().getContextPath() %>/js/ligerUI/js/core/base.js" type="text/javascript"></script>
<script src="<%=pageContext.getServletContext().getContextPath() %>/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
<script src="<%=pageContext.getServletContext().getContextPath() %>/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
<script src="<%=pageContext.getServletContext().getContextPath() %>/js/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
<script type="text/javascript">
   
   $(function(){
	  
	   $("#register").click(function(){
   		
   		/**onclick="return confirm('您确定要退出系统吗？');"	
   		/** parent从主界面进行退出,避免局部刷新*/
   		parent.location.href="<%=pageContext.getServletContext().getContextPath() %>/jsp/register.jsp";
   		
   	
	})
	   
	   
	    /** 按了回车键 */
	   $(document).keydown(function(event){
		   if(event.keyCode == 13){
			   $("#login-submit-btn").trigger("click");
		   }
	   })
       /** 按了回车键 */
	   $(document).keydown(function(event){
		   if(event.keyCode == 13){
			   $("#register-submit-btn").trigger("click");
		   }
	   })
	     /** 给注册按钮绑定点击事件  */
	   $("#register-submit-btn").on("click",function(){
		   /** 校验登录参数 ctrl+K */
		   var loginname = $("#loginname").val();
		   var password = $("#password").val();
		   
		   var msg = "";
		   
		   if(!/^\w{4,20}$/.test(loginname)){
			     msg = "登录名长度必须是6~20之间";
		   }else if(!/^\w{4,20}$/.test(password)){
			     msg = "密码长度必须是6~20之间";
		   }
		   if(msg !=""){
			   $.ligerDialog.error(msg);
			   return;
		   }
		   /** 提交表单 */
		   $("#loginForm").submit();
		   
	   })
	   
	   /** 给登录按钮绑定点击事件  */
	   $("#login-submit-btn").on("click",function(){
		   /** 校验登录参数 ctrl+K */
		   var loginname = $("#loginname").val();
		   var password = $("#password").val();
		   
		   var msg = "";
		   
		   if(!/^\w{4,20}$/.test(loginname)){
			     msg = "登录名长度必须是6~20之间";
		   }else if(!/^\w{4,20}$/.test(password)){
			     msg = "密码长度必须是6~20之间";
		   }
		   if(msg !=""){
			   $.ligerDialog.error(msg);
			   return;
		   }
		   /** 提交表单 */
		   $("#loginForm").submit();
		   
	   })
	   
   })
 


</script>
<script type="text/javascript">
var index = 0;
function changeImg(){
if (index == 16) {
index =0;
}
var current = index + 1;
document.getElementById('img1').src="<%=pageContext.getServletContext().getContextPath() %>/images/meitu/"+current + ".jpg";
index++;

setTimeout("changeImg()",5000);

}

</script>
 
 
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body  onload="changeImg()">
<img src="" alt="" width="100%" height="100%" id="img1">  
	<div class="page-lock">
		<div class="page-logo" style="margin-bottom: 2px">
			<a class="brand" href="login.html"
				style="font-size: 22px; color: #CC00DE;"> 人事管理<font color="#FFCC00">Hrm</font><span
				style="font-size: 13px;">1.0</span> 系统
			</a>
		</div>
		<form action="<%=pageContext.getServletContext().getContextPath() %>/user/login.action" method="post" id="loginForm">
			<span>&nbsp;</span>
					
							<span style="padding-top: 20px"><font color="red"><h3> ${error}</h3></font></span>
				
			<div class="page-body">
				<img class="page-lock-img"
					src="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/img/profile/logoend.jpg" alt="">
				<div class="page-lock-info">
					
					<c:choose>
						<c:when test="${requestScope.message == null }">
							<span style="padding-top: 5px;color:#FF00CC">允许以中文名称登录</span>
						</c:when>
						
					</c:choose>
					
					<div class="control-group">
		
						<div class="controls">
							<div class="input-icon left">
								<i class="icon-user"></i> <input
									class="m-wrap placeholder-no-fix" type="text" placeholder="帐号"
									id="user_loginname" name="user_loginname" value="${user_loginname}">
							</div>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<div class="input-icon left">
								<i class="icon-lock"></i> <input
									class="m-wrap placeholder-no-fix" type="password"
									placeholder="密码" id="user_password" name="user_password"
									value="${user_password}">
							</div>
						</div>
					</div>
				</div>
				<div class="relogin">
						<!-- 单击登录 -->
						<button type="submit" id="login-submit-btn" class="btn blue"
							style="margin-left: 20px">
							登录系统 <i class="m-icon-swapright m-icon-white"></i>
						</button>
						
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<!-- 点击注册 -->
						<a href="javascript:void(0);" type="submit" id="register" class="btn green"
						style="margin-right:20px">
						双击注册<i class ="m-icon-swapright m-icon-white"></i>
						</a>
				</div>
				</div>
				
			<div class="page-footer" style="color:#030303">
			
				兼容浏览器Firefox，谷歌Chrome，IE8+ 最佳分辨率2K. <br>2018 哈尔滨工程大学@李振钦  http://www.lzq.com
				<br>开发者联系电话 18045139175
			</div>
		
		</form>
	</div>
	
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script
		src="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/plugins/jquery-ui/jquery-ui-1.10.1.custom.min.js"
		type="text/javascript"></script>
	<script src="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!--[if lt IE 9]>
   <script src="${ctx}/js/metronic/plugins/excanvas.js"></script>
   <script src="${ctx}/js/metronic/plugins/respond.js"></script>  
   <![endif]-->
	<script src="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/plugins/breakpoints/breakpoints.js"
		type="text/javascript"></script>
	<!-- IMPORTANT! jquery.slimscroll.min.js depends on jquery-ui-1.10.1.custom.min.js -->
	<script src="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/plugins/uniform/jquery.uniform.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script
		src="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/plugins/backstretch/jquery.backstretch.min.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<script src="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/scripts/app.js"></script>
	<script src="<%=pageContext.getServletContext().getContextPath() %>/js/metronic/scripts/lock.js"></script>
	<script>
		$(function() {
			App.init();
			Lock.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-37564768-1' ]);
		_gaq.push([ '_setDomainName', 'keenthemes.com' ]);
		_gaq.push([ '_setAllowLinker', true ]);
		_gaq.push([ '_trackPageview' ]);
		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://'
					: 'http://')
					+ 'stats.g.doubleclick.net/dc.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
</body>
<!-- END BODY -->
</html>