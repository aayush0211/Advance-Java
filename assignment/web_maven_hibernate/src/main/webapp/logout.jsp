<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error_handling.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogOut page</title>
</head>
<body>
      <h4>Hello 
      <c:choose>
      <c:when test="${sessionScope.playerBean.player!=null}">
      ${sessionScope.playerBean.player.name}<br>
      you choose team ${sessionScope.playerBean.team.name} <br>
      ${sessionScope.playerBean.message}</c:when>
      <c:otherwise>
      ${sessionScope.teamBean.team.name}<br>
      ${sessionScope.teamBean.message}</c:otherwise>
      </c:choose>
      </h4>
      <% session.invalidate(); %>
</body>
</html>