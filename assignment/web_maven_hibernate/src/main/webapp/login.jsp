<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error_handling.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IPL Registration</title>
</head>
<jsp:useBean id="playerBean" class="beans.PlayerBean" scope="session"></jsp:useBean>
<jsp:useBean id="teamBean" class="beans.TeamBean" scope="session"></jsp:useBean>
<body>
<h4>${sessionScope.playerBean.message}</h4>
      <form action="validate_player.jsp" method="post">
      <h4>Team : </h4>
     <select name="teamId">
      <c:forEach var="t" items="${sessionScope.teamBean.getAllTeam()}">
      <option value="${t.getId()}">${t.getAbbr()}</option>
      </c:forEach>
      </select>
      <h4>Name :</h4>
      <input type="text" placeholder="enter player name" name="playerName" required="required" autofocus="autofocus">
      <h4>Dob :</h4>
      <input type="date" name="dob" >
      <h4>Batting Avg : </h4>
      <input type="number" name="battingAvg">
      <h4>Wickets : </h4>
      <input type="number" name="wickets">
      <br>
      <input type="submit" value="Add Player"><br>
      <a href="add_team.jsp">Register New Team</a></form>
</body>
</html>