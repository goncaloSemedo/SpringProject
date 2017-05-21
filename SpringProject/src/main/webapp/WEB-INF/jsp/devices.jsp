<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<div style="padding:20px;margin-top:30px;height:1500px;">
<table id="budgetTbl" action="" method="post" class="table table-striped table-bordered table-hover">
    <thead>
        <tr>
            <th>Atribute</th>
            <th>Fingerprint</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${fingerprints}" var="fingerprint" varStatus="status">
            <tr>
                <td>${fingerprint.atributeName}</td>
                <td><form:checkbox path="${fingerprint.fingerprint}" /></td>
            </tr>       
        </c:forEach>
    </tbody>
</table>
</div>
</html>