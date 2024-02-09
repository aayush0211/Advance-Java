<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%-- invoke all matching setters --%>
<jsp:setProperty property="*" name="user"/>
<h4> Route: ${sessionScope.user.registerNewVoter()} </h4>
<h4><a href = "login.jsp">Back to login </a></h4>
<body>
	
</body>
</html>