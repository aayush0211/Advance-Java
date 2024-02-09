<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>authentication_player Page</title>
</head>
<!-- transfer date to bean name should be same of id of bean instance -->
<jsp:setProperty property="*" name="playerUser"/>
<h4>Ruote : ${sessionScope.playerBean.getTeamDetails}</h4>
<body>
     
</body>
</html>