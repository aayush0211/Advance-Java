<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error_handling.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validate Team</title>
</head>
<jsp:setProperty property="*" name="teamBean"/>
<c:redirect url="${sessionScope.teamBean.addTeam()}.jsp"></c:redirect>
<body>

</body>
</html>