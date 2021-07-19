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
		          
		        </div>
		      </li>	
		      
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
		    <li class="breadcrumb-item">商品管理</li>
		  </ol>
	</nav>
	 <div class="container-fluid">
       <div class="row">
         <div id="queryArea" class="col-12">
           <form action="deviceMgr" method="post">
             <input type="hidden" name="task" value="load2Device"/>
             <div class="form-row">
               <div class="form-group col-3">
                   <select name="DeviceqryCategory" class="form-control">
                      <option value="">-请选择所属分类-</option>
                      <option  >生活用品</option>
                       <option  >化妆品</option>
                       <option  >食物</option>
                       <option  >母婴用品</option>
                       <option >衣物</option>
			       </select>                            
               </div>              
               <div class="form-group col-3">
                    <select name="DeviceqryName" class="form-control">
                        <option value="">-请选择商品名称-</option>
                       <c:forEach var="device" items="${deviceList}">
                      <option value="${device.deviceName}" <c:if test="${param.DeviceqryName==device.deviceName}">selected</c:if>>${device.deviceName}</option>                     
                      </c:forEach>
			        </select>                            
               </div>               
               
               <div class="form-group col-md-3">
                    <button class="btn btn-primary"> 查询商品 </button>
               </div>                                             
             </div>             
           </form>
         </div>
       </div> 
    <div class="container-fluid">
	   <div class="row">
	   
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">商品类别</th>
		      <th scope="col">商品名称</th>
		      <th scope="col">商品编号</th>
		      <th scope="col">图片</th>
		      <th scope="col">数量</th>
		      <th scope="col">单价</th>
		       <th scope="col">保质期</th>
		       <th scope="col">生产日期</th>
		       <th scope="col">操作</th>
		    </tr>
		  </thead>
		  <tbody>
		    
		    <tr>
		      <th scope="row">食物</th>
		      <td>面</td>
		      <td>33</td>
		       <td>
		        <img style="margin-bottom:2px;" width="140" height="100" src="<c:url value="/deviceMgr"/>?task=loadPic&deviceid=${device.deviceId}">
		        <br>
		        ${device.deviceModel}
		      </td>
		      
		      <td>2</td>
		      <td>90000</td>
		      <td>一个月</td>
		      <td>2021-2-10</td>
		      <td>
		    <button class="btn btn-danger btn-sm" onclick="showRemoveDlg(${device.deviceId})">加入购物车</button>
		      </td>
		    </tr>
		    <tr>
		      <th scope="row">衣物</th>
		      <td>面</td>
		      <td>11</td>
		       <td>
		        <img style="margin-bottom:2px;" width="140" height="100" src="<c:url value="/deviceMgr"/>?task=loadPic&deviceid=${device.deviceId}">
		        <br>
		        ${device.deviceModel}
		      </td>
		      
		      <td>2</td>
		      <td>90000</td>
		      <td>十年</td>
		      <td>2021-2-10</td>
		      <td>
		      <button class="btn btn-danger btn-sm" onclick="showRemoveDlg(${device.deviceId})">加入购物车</button>
		      </td>
		    </tr>
		    <tr>
		      <th scope="row">衣物</th>
		      <td>面</td>
		      <td>31</td>
		       <td>
		        <img style="margin-bottom:2px;" width="140" height="100" src="<c:url value="/deviceMgr"/>?task=loadPic&deviceid=${device.deviceId}">
		        <br>
		        ${device.deviceModel}
		      </td>
		      
		      <td>2</td>
		      <td>90000</td>
		      <td>一年</td>
		      <td>2021-2-10</td>
		      <td>

		        <button class="btn btn-danger btn-sm" onclick="showRemoveDlg(${device.deviceId})">加入购物车</button>
		      </td>
		    </tr>
		    <tr>
		      <th scope="row">化妆品</th>
		      <td>面</td>
		      <td>30</td>
		       <td>
		        <img style="margin-bottom:2px;" width="140" height="100" src="<c:url value="/deviceMgr"/>?task=loadPic&deviceid=${device.deviceId}">
		        <br>
		        ${device.deviceModel}
		      </td>
		      
		      <td>2</td>
		      <td>90000</td>
		      <td>一年</td>
		      <td>2021-2-10</td>
		      <td>
		        <button class="btn btn-danger btn-sm" onclick="showRemoveDlg(${device.deviceId})">加入购物车</button>
		      </td>
		    </tr>
		  </tbody>
		</table>	     
	   </div>
	</div>	
	<div class="modal fade" tabindex="-1" id="removeDeviceModal">
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
	        <button type="button" class="btn btn-primary" onclick="removeDevice()">删 除</button>
	      </div>
	    </div>
	  </div>
	</div>	
	<div class="col-12 text-right" style="margin-top: -30px;">
			  共13条, 当前显示1-4条, 第1/4页
			 
		             
		        
		        
		          
		             <button class="btn btn-sm btn-outline-info" onclick="doQuery(${page.pageNo+1})">下一页</button>&nbsp;
		       
		          
		             <button class="btn btn-sm btn-outline-info" onclick="doQuery(${page.totalPageNum})">末页</button>&nbsp;
		           
		      &nbsp;|&nbsp;
		                      到&nbsp;<input type="text" class="text-center" id="pageNo" size=4 style="text-align:right;"/> 页
		           <button class="btn btn-sm btn-success" onclick="doQuery(parseInt($('#pageNo').val()));"> 跳 转 </button>     
		 </div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>