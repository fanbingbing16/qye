<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/vendor/bootstrap-4.3.1-dist/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/vendor/fontawesome-free-5.8.1-web/css/all.min.css"/>"/>
<script type="text/javascript" src="<c:url value="/vendor/jquery/jquery-3.3.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/vendor/popper.js/popper.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/vendor/bootstrap-4.3.1-dist/js/bootstrap.min.js"/>"></script>

</head>
<body background="pics/c.JPG" style="background-size: 100%;">
      <nav class="navbar navbar-expand-md navbar-light bg-light">
      <img src="pics/logo.png" width="20px" height="20px">
       <a class="navbar-brand" href="#"><b>购物系统</b></a>
       <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
	   </button> 
	   <div class="collapse navbar-collapse" id="navbarSupportedContent">
	       <ul class="navbar-nav mr-auto">
	          <li class="nav-item active">
		        <a class="nav-link" href="login_list.html">首页</a>
		      </li>
              <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                       商品管理
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">          		          
		          <a class="dropdown-item" href='deviceMgr?task=loadDevice'>商品管理</a>		
		          	 <a class="dropdown-item" href='input_device.jsp'>商品增加</a>	
		        </div>
		      </li>	
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                      报修管理
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">          		          
		          <a class="dropdown-item" href='input_repair.jsp'>报修管理</a>		
		          	<a class="dropdown-item" href='repairMgr?task=loadRepair'>报修列表</a>
		        </div>
		      </li>
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="input_buy.jsp" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                   用户管理                
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">          		          
		          <a class="dropdown-item" href='input_buy.jsp'>用户管理</a>		
		          	<a class="dropdown-item" href='buyMgr?task=loadBuy'>用户信息列表</a>	
		        </div>
		      </li>			      		      	      
	       </ul>
           <ul class="navbar-nav ml-auto">
		       <li class="nav-item">
		           <a class="nav-link">
		             <i class="fas fa-user" style="color:deeppink"></i> ${User.userName}
		           </a>
		       </li>
               <li class="nav-item">
		        <a class="nav-link" href="index.jsp">退出系统</a>
		      </li>		       
		   </ul>		       
	   </div>      
    </nav>
    <!-- 面包屑导航条 -->
    <nav aria-label="breadcrumb">
		  <ol class="breadcrumb" style="border-radius:0em">
		    <li class="breadcrumb-item">首页</li>
		    <li class="breadcrumb-item">用户管理</li>
		  </ol>
	</nav> 
    <div class="container-fluid">
	   <div class="row">
	      <div class="col-12 col-md-6">
	         <form action="buyMgr" method="post">
	              <input type="hidden" name="task" value="createBuy"/>
				  <div class="form-group">
				    <label>账号</label>
				    <input name="userid" class="form-control" placeholder="请输入用户账号">
				  </div>
			      <div class="form-group">
			        <label for="userPaw">密码</label><br>
			        <input name="userpaw" class="form-control" placeholder="请输入用户密码">
			        
			      </div>				  
			      <div class="form-group">
			        <label for="userAnser">密保问题1答案</label>
			        <input name="useranser" class="form-control" placeholder="请输入答案">
			      </div>
			      <div class="form-group">
			        <label for="userAnser2">密码问题2答案</label>		
			        <input name="useranser2" class="form-control" placeholder="请输入答案">
			      </div>
			      <input type="submit" class="btn btn-primary" value="保存">					      				  	         
	         </form>  
	      </div>
	   </div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>