<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<div style="padding:20px;margin-top:30px;">
<form:form method="GET" commandName="model">


<form >
  <input type="checkbox" name="vehicle" value="Bike"> I have a bike<br>
  <input type="checkbox" name="vehicle" value="Car" checked> I have a car<br>
  <input type="submit" value="Submit">
</form>

<table>
        <tr>
            <th>Attribute</th>
            <th>Fingerprint</th>
        </tr>
        <tr>
        	<c:forEach items="${fingerprints}" var="current">	
	    		<td>${current.atributeName}</td>
	    		<td><form:checkbox path="${current.fingerprint}"/>cenas</td>
    		</c:forEach>
  		</tr>        
</table>
</form:form>
</div>
</html>