<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ADMIN</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.1.0/material.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/dataTables.material.min.css">
  <link rel="stylesheet" href="css/login.css">
  <link rel="stylesheet" href="css/app.css">
  <link rel='stylesheet' href='https://cdn.rawgit.com/daneden/animate.css/v3.1.0/animate.min.css'>
  <script src='https://cdn.rawgit.com/matthieua/WOW/1.0.1/dist/wow.min.js'></script>
  <script src="https://code.jquery.com/jquery-1.12.3.js"></script>
  <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.12/js/dataTables.material.min.js"></script>
  <script src="js/login.js"></script>
  
</head>
<body>
  <jsp:include page="components/header.jsp"></jsp:include>
  <div class="container-fluid">
   <form action="LoginFilter" class="login">
    <legend class="legend">Login</legend>
    
    <div class="input">
      <input type="text" placeholder="username" name="username" required />
      <span><i class="fa fa-envelope-o"></i></span>
    </div>
    
    <div class="input">
      <input type="password" placeholder="Password" name="pass"  required />
      <span><i class="fa fa-lock"></i></span>
    </div>
    
    <button type="submit" class="submit"><i class="fa fa-long-arrow-right"></i></button>
    
  
</form>
  </div>
  
  <!--div class="positionBookingView">
    <div>
      
    </div>
  </div -->
</div>
<%@ include file = "components/footer.html" %>
</body>
</html>