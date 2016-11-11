<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ADMIN</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-1.12.3.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.1.0/material.min.css">
  <link rel='stylesheet' href='https://cdn.rawgit.com/daneden/animate.css/v3.1.0/animate.min.css'>
  <script src='https://cdn.rawgit.com/matthieua/WOW/1.0.1/dist/wow.min.js'></script>
  <link rel="stylesheet" href="css/app.css">
  
</head>
<body>
  <div class="container-fluid Mycontainer-fluid center">
  <jsp:include page="components/header.jsp"></jsp:include>
      
    <script type="text/javascript">
      function createIntro() {
        var components = [];
        var str = 'wellcome!';
        for (var i = 0; i < str.length; i++) {
          components.push(
            '<span class="wow lightSpeedIn" data-wow-duration="'+(str.length-i)*0.2+'s" data-wow-delay="'+i*0.2+'s" data-wow-iteration="2">'+str.charAt(i)+'</span>'
          );
        }
         $("#wellcome").html('<h1  class="wow fadeOut wellcome"  data-wow-duration="2s" data-wow-delay="'+(str.length+1)*0.2+'s" data-wow-iteration="1">'+components.join('')+'</h1>');
      }

      $(document).ready(function(){
        createIntro();
      });
    </script>
    <div id="wellcome"></div>

    <div class="loginForm wow flipInX" data-wow-duration="1s" data-wow-delay="4s">
      <form action="LoginFilter" class="login">
        <div class="title">Login</div>
        <div class="input">
          <span class="iconLogin glyphicon glyphicon-user"></span><input type="text" placeholder="username" name="username" required />
        </div>
        <div class="input">
          <span class="iconLogin glyphicon glyphicon-option-horizontal"></span><input type="password" placeholder="Password" name="pass"  required />
        </div>
        <button type="submit" class="btn btn-primary submit"><i>Login</i></button>
      </form>
    </div>
  </div>

  


  <!--div class="positionBookingView">
    <div>
      
    </div>
  </div -->


</body>
</html>