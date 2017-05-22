<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<spring:url value="css/style.css" />" rel="stylesheet"
	type="text/css">
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
<meta charset="UTF-8">
<title>Admin Console</title>
</head>


<body>
<header>
	<ul>
  <li><a href="#home">Home</a></li>
  <li><a onclick="renderPage('devices')">Devices Fingerprint</a></li>
  <li><a onclick="renderPage('search')">Search</a></li>
  <li><a href="/logout">Logout</a></li>
</ul>
</header>

	

<div id="content">
</div>

</body>


<script type="text/javascript">

function renderPage(tab) {
    
    
       var url ='/' +tab;
    
    $("#content").load(url);
}

</script>

</html>
