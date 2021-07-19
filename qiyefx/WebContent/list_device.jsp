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

    var delDeviceId;
    
    function showRemoveDlg(deviceId){
    	//alert(hotelId+","+hotelName);
    	delDeviceId = deviceId;
    	$("#message").html('您确认要删除账号  ['+deviceId+'] 吗?');
    	$("#removeDeviceModal").modal('show');
    }
   
    function removeDevice(){
    	location.href="<c:url value="/deviceMgr?task=removeDevice&deviceid="/>" +delDeviceId;
    }
    
    function doQuery(pageNo){
       	
    	   if(pageNo<1 || pageNo>${page.totalPageNum})
           {
              alert('页号超出范围，有效范围：[1-${page.totalPageNum}]!');
              $('#pageNo').select();
              return;
           }
           else{
    	         document.forms[0].action += "?pageno="+pageNo;
    	         document.forms[0].submit();
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
             <input type="hidden" name="task" value="loadDevice"/>
             <div class="form-row">
               <div class="form-group col-3">
                   <select name="DeviceqryCategory" class="form-control">
                      <option value="">-请选择所属分类-</option>
                      <option value="${device.deviceCategory} " <c:if test="${param.DeviceqryCategory==device.deviceCategory}">selected</c:if>>生活用品</option>
                       <option  value="${device.deviceCategory} " <c:if test="${param.DeviceqryCategory==device.deviceCategory}">selected</c:if>>化妆品</option>
                       <option  value="${device.deviceCategory} " <c:if test="${param.DeviceqryCategory==device.deviceCategory}">selected</c:if>>食物</option>
                       <option  value="${device.deviceCategory} " <c:if test="${param.DeviceqryCategory==device.deviceCategory}">selected</c:if>>母婴用品</option>
                       <option value="${device.deviceCategory} " <c:if test="${param.DeviceqryCategory==device.deviceCategory}">selected</c:if>>衣物</option>
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
	   <c:if test="${not empty page.pageContent}">
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
		    <c:forEach var="device" items="${page.pageContent}">
		    <tr>
		      <th scope="row">${device.deviceCategory}</th>
		      <td>${device.deviceName}</td>
		      <td>${device.deviceId}</td>
		       <td>
		        <img style="margin-bottom:2px;" width="140" height="100" src="<c:url value="/deviceMgr"/>?task=loadPic&deviceid=${device.deviceId}">
		        <br>
		        ${device.deviceModel}
		      </td>
		      <td>${device.deviceSpecificitions}</td>
		      <td>${device.shelfLife}</td>
		      <td>${device.operator}</td>
		      <td>${device.buyDate}</td>
		      <td>
		        <button class="btn btn-primary btn-sm">修改</button>
		        <button class="btn btn-danger btn-sm" onclick="showRemoveDlg(${device.deviceId})">下架</button>
		      </td>
		    </tr>
		    </c:forEach>
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
			  共${page.totalRecNum}条, 当前显示${page.startIndex+1}-${page.endIndex}条, 第${page.pageNo}/${page.totalPageNum}页
			 <c:if test="${page.totalPageNum>1}">|</c:if>
		           <c:if test="${page.pageNo>1}">
		             <button class="btn btn-sm btn-outline-info" onclick="doQuery(1)">首页</button>&nbsp;
		           </c:if>
		           <c:if test="${page.prePage}">
		             <button class="btn btn-sm btn-outline-info" onclick="doQuery(${page.pageNo-1})">上一页</button>&nbsp;
		           </c:if>
		           <c:if test="${page.nextPage}">
		             <button class="btn btn-sm btn-outline-info" onclick="doQuery(${page.pageNo+1})">下一页</button>&nbsp;
		           </c:if>
		           <c:if test="${page.pageNo!=page.totalPageNum}">
		             <button class="btn btn-sm btn-outline-info" onclick="doQuery(${page.totalPageNum})">末页</button>&nbsp;
		           </c:if>
		      &nbsp;|&nbsp;
		                      到&nbsp;<input type="text" class="text-center" id="pageNo" size=4 style="text-align:right;"/> 页
		           <button class="btn btn-sm btn-success" onclick="doQuery(parseInt($('#pageNo').val()));"> 跳 转 </button>     
		 </div>
		 </c:if>
		 <c:if test="${empty page.pageContent}">
              <div class="alert alert-danger text-center my-5 py-5 col-12 col-md-6 offset-md-3" role="alert">
					  没有任何符合条件的房间信息被查到！
			  </div>		   
		</c:if>	
		<jsp:include page="footer.jsp"></jsp:include>  
</body>
</html>