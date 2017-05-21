<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Login Form</title>
  
  
<link href="<spring:url value="css/style.css" />" rel="stylesheet"
	type="text/css">

  
</head>

<body>
  <html lang="en-US">
<head>
  <meta charset="utf-8">
    <title>Login</title>
    
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,700">

</head>


    <div id="login">
      <form action="/login" method="post">
        <span class="fontawesome-user"></span>
          <input type="text" name="username" placeholder="Username">
       
        <span class="fontawesome-lock"></span>
          <input type="password" name="password" placeholder="Password">
        
        <input type="submit" value="Login">
        <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

</form>
  
  
</body>
</html>









