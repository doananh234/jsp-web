<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
function getrequest(argument) {
		var xmlHttpreq = false;
	if (window.XMLHttpRequest) {
			xmlHttpreq = new XMLHttpRequest();

		} else if (window.ActiveXObject) {
			try {
				xmlHttpreq = new ActiveXObject("Msxm12.XMLHTTP");

			} catch (expl) {
				xmlHttpreq = false;
			}
	}

	return xmlHttpreq;
}

	function makeRequest() {
	var xmlHttpRequest = getrequest();
	xmlHttpRequest.onreadystatechange =
	getReadyStateHandler(xmlHttpRequest);
	xmlHttpRequest.open("GET", "asyncTest.jsp", true);
	xmlHttpRequest.send();
	} 		
function getReadyStateHandler(xmlHttpRequest) {
// an anonymous function returned
// it listens to the XMLHttpRequest instance
	return function() {
	if (xmlHttpRequest.readyState == 4) {
	if (xmlHttpRequest.status == 200) {
		console.log(xmlHttpRequest.responseText);
	document.getElementById("hello").innerHTML =
	xmlHttpRequest.responseText;
	} else {
	alert("HTTP error " + xmlHttpRequest.status + ": "
	+ xmlHttpRequest.statusText);
	}
	}
	};
} 
	</script>
	<div id="hello">asdas</div>
	<button onclick="makeRequest()">asdas</button>
</body>
</html>