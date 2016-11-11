<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Admin Page</title>
  <link rel="stylesheet" href="css/materialInput.css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-1.12.3.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.1.0/material.min.css">
  <link rel='stylesheet' href='https://cdn.rawgit.com/daneden/animate.css/v3.1.0/animate.min.css'>
  <script src='https://cdn.rawgit.com/matthieua/WOW/1.0.1/dist/wow.min.js'></script>
  <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.12/js/dataTables.material.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.1.0/material.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/dataTables.material.min.css">
  <link rel="stylesheet" href="css/MyDatatable.css">
  <script src="js/MyDatatable.js"></script>
  <link rel="stylesheet" href="css/app.css">
  
</head>
<body>
  <div class="container-fluid Mycontainer-fluid">
  <jsp:include page="components/header.jsp"></jsp:include>
    <div class="navBar  clearfix">
		<div class="navBarLeft clearfix"></div>
		<div class="navBarCenter clearfix">
			<span class="namePage">Dashboard</span>
		</div>
		<div class="navBarRight clearfix">
	        <button id="openAdd"  class="btn btn-success"><i>Add</i></button>
		</div>
	</div>

	<div class="content row container-fluid" style="background-color:#ffffff">
		
	    <h1>Tong cong: <label id="count"></label></h1>
		<div class="col-xs-12 col-md-12 col-sm-12 col-lg-12">

		<table id="listProduct" class="table table-hover table-bordered mdl-data-table ">
		   <thead>
				<tr id="headerTable" style="background-color:#ffffff">
					<th >Id</th>
					<th>Hình Ảnh</th>
					<th>Tên</th>
					<th>Giá</th>
					<th>Số lượng</th>
					<th>Thông tin</th>
					<th></th>
				</tr>

				<tr id="newRecordRow" style="background-color:#ffffff">
					<th ></th>
					<th><div class="form-group">
				    	<!-- <img id="subImgTag" src="assets/default.png" alt="img" style="width:100px;"> -->
				    	<form action="uploadServlet" id="uploadServlet" enctype="multipart/form-data" method="post">
					    	<input accept="image/*" type="file" id="img" name="file"/>
						</form>
				    </div></th>
					<th><div class="form-group">
	      				<input type="text" id="name"  name="name" placeholder="name" required="required"/>
    				</div></th>
					<th><div class="form-group">
				      <input type="text" id="price" name="price" placeholder="price" required="required"/>
				    </div></th>
					<th><div class="form-group">
				      <input type="text" id="quatity"  name="quatity"  placeholder="Quatity"  required="required"/>
				    </div></th>
					<th><div class="form-group">
				      <input type="text" id="info"  name="info" placeholder="info" required="required"/>
				    </div></th>
					<th><button id="addButton" class="btn btn-success popupButton"><i>Add</i></button></th>
				</tr>
			</thead>
		    <tbody id="renderlist">
		    </tbody>
			  <tfoot>
			  </tfoot>
		  </table>
			  	<div  class="col-xs-12 col-md-12 col-sm-12 col-lg-12" id="paging"></div>
		</div>
	</div>
  </div>




  <!-- <div id="popup" class="popup wow bounceInDown  center">
  	<div class="contentPopup">
  		<div class="popupInput">
  		<div class="form-group">
	      <input type="text" id="name"  name="name" required="required"/>
	      <label for="input" class="control-label">Name</label><i class="bar"></i>
	    </div>
	    <div class="form-group">
	      <input type="text" id="price" name="price"  required="required"/>
	      <label for="input" class="control-label">Price</label><i class="bar"></i>
	    </div>
	    <div class="form-group">
	      <input type="text" id="quatity"  name="quatity"  required="required"/>
	      <label for="input" class="control-label">Quatity</label><i class="bar"></i>
	    </div>
	    <div class="form-group">
	      <input type="text" id="info"  name="info" required="required"/>
	      <label for="input" class="control-label">Info</label><i class="bar"></i>
	    </div>
	    </div>
	    <div class="form-group">
	    	<img id="subImgTag" src="assets/default.png" alt="img" style="width:100px;">
	    	<form action="uploadServlet" id="uploadServlet" enctype="multipart/form-data" method="post">
		    	<input type="file" id="img" name="file"/>
			</form>
	    </div>
	    </div>
	    <div class="buttonRow center">
	        <button id="addButton" class="btn btn-success popupButton"><i>Add</i></button>
	        <button id="updateButton"  class="btn btn-info popupButton"><i>Update</i></button>
	        <button id="deleteButton"  class="btn btn-danger popupButton"><i>Delete</i></button>
	        <button id="close" class="btn popupButton"><i>Close</i></button>
		</div>
  	</div>-->
	</div>

</body>
</html>