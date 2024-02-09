<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation Page</title>
</head>
<%--create JB instance n add it under session,Key=id(user) value=new UserBean[default const'r call] --%>
<!-- jsp action runtime -->
<!--<jsp:useBean id="user" class="beans.UserBean" scope="session"/>-->
<%--transfer clnt's conversation state to JB --%>
<%--jsp call matching method of JavaBean with Req. parameter name --%>
<jsp:setProperty property="*" name="user"/>
<%--Invoke B.L from JB --%>
<h4>Route : ${sessionScope.user.authenticateUser()}</h4>
<!-- session.getAttribute(java bean id) -->
<body>

</body>
</html>