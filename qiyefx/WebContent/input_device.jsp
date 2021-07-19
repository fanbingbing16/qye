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
function previewImage(file){

	    var img = document.getElementById('picImg');
					
		if (file.files && file.files[0]) 			
		{		
		   
		   //准备一个文件读取器对象，并告诉它文件读取完毕之后要做什么。
		   var reader = new FileReader();			  
		   //成功读取了图片信息后，把读取结果赋予 	
		   
		  //FileReader.readAsDataURL()
	   //开始读取指定的Blob中的内容。一旦完成，result属性中将包含一个data: URL格式的字符串以表示所读取文件的内容。			   		
		   reader.onload = function(evt){
		    img.src= evt.target.result;
		    console.log("read ok! img src get value!"+evt.target.result);
		   }
		
		   console.log("start to read!")
		   reader.readAsDataURL(file.files[0]);
		
		}
	    else{
	       img.src="pics/1.JPG";
	      // alert("no upload file!");
	    }
		
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
		             <i class="fas fa-user" style="color:deeppink"></i> ${loginedUser.userName}
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
		    <li class="breadcrumb-item">增加商品</li>
		  </ol>
	</nav> 
    <div class="container-fluid">
	   <div class="row">
	      <div class="col-12 col-md-6">
	         <form action="deviceMgr" method="post">
	              <input type="hidden" name="task" value="createDevice"/>
				  <div class="form-group">
				    <label>商品类别</label>
				    <div class="form-check form-check-inline">			      
					  <input class="form-check-input" type="radio" name="devicecategory" >
					  <label class="form-check-label">生活用品</label>
					</div>
				    <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="devicecategory" >
					  <label class="form-check-label">母婴用品</label>
					</div>
				    <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="devicecategory" >
					  <label class="form-check-label">食物</label>
					</div>
				    <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="devicecategory" >
					  <label class="form-check-label">衣物</label>
					</div>			
				    <div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="devicecategory" >
					  <label class="form-check-label">化妆品</label>
					</div>
					</div>
			      <div class="form-group">
			        <label for="devicename">商品名称</label><br>
			        <input name="devicename" class="form-control" placeholder="请输入商品名称">
			        
			      </div>				  
			      <div class="form-group">
			        <label for="deviceid">商品编号</label>
			        <input name="deviceid" class="form-control" placeholder="请输入编号">
			      </div>
			      <div class="form-group">
			        <label>商品照片</label><br>
			        <img id="picImg" src="pics/1.JPG" width="200" height="130" class="py-1"><br>
			        <input type="file" name="devcemodel" class="form-control-file" onchange="previewImage(this)">
			      </div>
			      <div class="form-group">
			        <label for="devicespecificitions">数量</label>
			        <input name="devicespecificitions" class="form-control" placeholder="请输入商品数量">
			      </div>
			      <div class="form-group">
			        <label for="shelflife">单价</label>
			        <input name="shelflife" class="form-control" placeholder="请输入商品单价">
			      </div>
			      <div class="form-group">
					<label for="hotelPhoto">保质期</label><br>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="operator" value="f">
					  <label class="form-check-label">七天</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="operator" value="g">
					  <label class="form-check-label">一个月</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="operator" value="h">
					  <label class="form-check-label">三个月</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="operator" value="i">
					  <label class="form-check-label">半年</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="operator" value="j">
					  <label class="form-check-label">一年</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="operator" value="k">
					  <label class="form-check-label">五年</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" name="operator" value="m">
					  <label class="form-check-label">十年</label>
					</div>																												
				  </div>
			      <div class="form-group">
			        <label for="buydate">生产日期</label>		
			        <input name="buydate" class="form-control" placeholder="请输入生产日期">
			      </div>
			      <input type="submit" class="btn btn-primary" value="保存">					      				  	         
	         </form>  
	      </div>
	   </div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>