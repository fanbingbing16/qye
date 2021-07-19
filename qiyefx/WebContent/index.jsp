<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="<c:url value="/vendor/bootstrap-4.3.1-dist/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/vendor/fontawesome-free-5.8.1-web/css/all.min.css"/>"/>
<script type="text/javascript" src="<c:url value="/vendor/jquery/jquery-3.3.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/vendor/popper.js/popper.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/vendor/bootstrap-4.3.1-dist/js/bootstrap.min.js"/>"></script>

  </head>
  
  <body background="pics/c.JPG" style="background-size: 50%;">
             <div class="panel" style="width: 400px;margin-top: 100px;margin-left: 500px;">
				<div style="margin-left: 220px;">
					<img src="pics/logo.png" width="50px"height="50px">
				</div>
    <div class="container">
       <div class="row col-12 col-md-6 offset-md-3" style="margin-top:px">
         <h2><b>ABC购物系统 v2.0</b></h2>
         <hr>
       </div>
       <div class="row py-5">
        <form action="securityMgr" method="post" class="col-12 col-md-6 offset-md-3">
           <input type="hidden" name="task" value="login"/>
           <div class="form-group">
		    <label for="username"><svg xmlns="http://www.w3.org/2000/svg"
							width="16" height="16" fill="currentColor" class="bi bi-emoji-laughing" viewBox="0 0 16 16">
							<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
							<path
								d="M12.331 9.5a1 1 0 0 1 0 1A4.998 4.998 0 0 1 8 13a4.998 4.998 0 0 1-4.33-2.5A1 1 0 0 1 4.535 9h6.93a1 1 0 0 1 .866.5zM7 6.5c0 .828-.448 0-1 0s-1 .828-1 0S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 0-1 0s-1 .828-1 0S9.448 5 10 5s1 .672 1 1.5z" />
						</svg>账户名称</label>
		    <input type="text" name="username" class="form-control" placeholder="请输入6位账号信息" maxlength="6" >
		   </div>
           <div class="form-group" style="magin-left:200px">
		    <label for="filmpassword"><svg xmlns="http://www.w3.org/2000/svg"
							width="16" height="16" fill="currentColor" class="bi bi-chat-left-dots" viewBox="0 0 16 16">
							<path
								d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H4.414A2 2 0 0 0 3 11.586l-2 2V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12.793a.5.5 0 0 0 .854.353l2.853-2.853A1 1 0 0 1 4.414 12H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z" />
							<path
								d="M5 6a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z" />
						</svg>账户密码</label>
		    <input type="password" name="userpassword" class="form-control" placeholder="请输入密码信息" maxlength="6">
		   </div>
           <c:if test="${not empty errMsg}">
            <div class="alert alert-danger text-center">
			  ${errMsg}
		    </div>		
		   </c:if>		   	   
		   <div>
		    <button class="btn btn-primary">管理员登录</button>
		   </div>		   		               
        </form>
        <div  class="with-padding" style="margin-top: -55px;margin-left: 230px;">
					<a href="index2.jsp">
					<button class="btn btn-block  btn-danger" type="button" >普通用户</button>
					</a>
				</div>
        
				
      </div>
    </div>
   <div  class="with-padding" style="margin-top: -103px;margin-left: 340px;">
					<a href="zhuc.html">
					<button class="btn btn-block  btn-danger" type="button" >注册</button>
					</a>
				</div>
				<jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
