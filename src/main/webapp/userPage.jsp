<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Page</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-1.12.3.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.1.0/material.min.css">
  <link rel='stylesheet' href='https://cdn.rawgit.com/daneden/animate.css/v3.1.0/animate.min.css'>
  <script src='https://cdn.rawgit.com/matthieua/WOW/1.0.1/dist/wow.min.js'></script>
  <link rel="stylesheet" href="css/app.css">
  <link rel="stylesheet" href="css/product.css">
  <script src="js/renderGridProduct.js"></script>
  
</head>
<body>
  <div class="container-fluid Mycontainer-fluid">
  <jsp:include page="components/header.jsp"></jsp:include>
    <div class="navBar  clearfix">
		<div class="navBarLeft  clearfix"></div>
		<div class="navBarCenter  clearfix">
			<span class="namePage">Wellcome to MyShop</span>
		</div>
		<div class="navBarRight  clearfix"></div>
	</div>

	<div class="content container-fluid">
		<div id="gridProduct" class="row">
		</div>
	</div>
  </div>

  
<div id="paging" value="<%=(long)request.getAttribute("count")%>"></div>

  <!--div class="positionBookingView">
    <div>
      
    </div>
  </div -->


</body>
</html>