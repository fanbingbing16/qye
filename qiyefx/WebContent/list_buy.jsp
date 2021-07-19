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
<script type="text/javascript">

    var delUserId;
    
    function showRemoveDlg(userId){
    	//alert(hotelId+","+hotelName);
    	delUserId = userId;
    	$("#message").html('您确认要删除账号  ['+userId+'] 吗?');
    	$("#removeBuyModal").modal('show');
    }
    
    function removeBuy(){
    	location.href="<c:url value="/buyMgr?task=removeBuy&userid="/>" +delUserId;
    }
    function updateBuy(userid){
    	location.href="<c:url value="/buyMgr?task=preUpdateBuy"/>&userid="+userid;
    }
    
    function showRemoveDlg2(userId){
    	//alert(hotelId+","+hotelName);
    	delUserId = userId;
    	$("#message2").html('您确认要禁止用户  ['+userId+'] 登录吗?');
    	$("#removeBuyModal2").modal('show');
    }
    function removeBuy2(){
    	location.href="<c:url value="/buyMgr?task=removeBuy&userid="/>" +delUserId;
    }

</script>
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
		             <i class="fas fa-user" style="color:deeppink"></i> ${buy.userId}
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
		    <li class="breadcrumb-item">用户信息列表</li>
		  </ol>
	</nav> 
    <div class="container-fluid">
	   <div class="row">
		<table class="table">
		  <thead>
		    <tr>

		      <th scope="col">账号</th>
		      <th scope="col">密码</th>
		      <th scope="col">密保问题1答案</th>
		      <th scope="col">密保问题2答案</th>
		       <th scope="col">操作</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach var="buy" items="${buyList}">
		    <tr>
		      <th scope="row">${buy.userId}</th>
		      <td>${buy.userPaw}</td>
		      <td>${buy.userAnser}</td>
		      <td>${buy.userAnser2}</td>
		      <td>
		        <button class="btn btn-primary btn-sm" onclick="updateBuy(${buy.userId});">修改</button>
		        <button class="btn btn-danger btn-sm" onclick="showRemoveDlg(${buy.userId})">删除</button>
		        <button class="btn btn-danger btn-sm" onclick="showRemoveDlg2(${buy.userId})">禁止该用户登录</button>
		      </td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>	     
	   </div>
	   <input type="submit" class="btn btn-primary" value="提交申请">	
	</div>
	<div class="modal fade" tabindex="-1" id="removeBuyModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">系统提示</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <p id="message"></p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">关 闭</button>
	        <button type="button" class="btn btn-primary" onclick="removeBuy()">删 除</button>
	      </div>
	    </div>
	  </div>
	</div>
	<div class="modal fade" tabindex="-1" id="removeBuyModal2">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">系统提示</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <p id="message2"></p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">关 闭</button>
	        <button type="button" class="btn btn-primary" onclick="removeBuy2()">删 除</button>
	      </div>
	    </div>
	  </div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>		
</body>
</html>