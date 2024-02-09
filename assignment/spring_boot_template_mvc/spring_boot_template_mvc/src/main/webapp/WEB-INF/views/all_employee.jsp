<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employee</title>
</head>
<body>
	<table border="thin" >
		<th colspan="4">
			All Employee Details
		</th>
		<tr>
			<td>
				First Name
			</td>
			<td>
				Last Name
			</td>
			<td>
				 City
			</td>
			<td>
				Company Name
			</td>
		</tr>
		<c:forEach var="emp" items="${requestScope.list}">
			<tr>
				<td>
					${emp.firstName}
				</td>
			
				<td>
					${emp.lastName}
				</td>
				<td>
					${emp.city}
				</td>
				<td>
					${emp.companyName}
				</td>
			</tr>				
		</c:forEach>
	
	<spring:url var="url" value="/" />
	</table> <h5><a href = "${url}" }>Back to Homepage </a></h5>
</body>
</html>