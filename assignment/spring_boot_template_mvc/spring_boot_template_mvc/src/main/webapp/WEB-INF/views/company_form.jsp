<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri = "http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4> ${requestScope.msg} </h4>
	<spring:url var="url" value="/employee/all_by_company" />
	<form action="${url}" method="post">
		<h4>
			Enter Company Name
		</h4>
			<h4> <input type="text" name="cmp"/> </h4>
			<input type="submit" value="Find All Employee By Company" />
	</form>
</body>
</html>