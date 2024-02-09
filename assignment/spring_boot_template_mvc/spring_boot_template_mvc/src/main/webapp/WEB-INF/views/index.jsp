<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome!!!!</title>
</head>
<body>
	<h4> ${requestScope.msg} </h4>
	<h5>
		<spring:url var="url" value="/employee/form" />
		<a href="${url}">Add Employee Form</a>
	</h5>
	<h5>
		<spring:url var="url" value="/employee/all" />
		<a href="${url}">Get All Employees </a>
	</h5>

<h5>
		<spring:url var="url" value="/employee/all_by" />
		<a href="${url}">Get All Employees By Company </a>
	</h5>
</body>
</html>