<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error_handling.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Team</title>
</head>
<body>
<h4>${sessionScope.teamBean.message}</h4>
     <form action="validate_team.jsp" method="post">
      <h4>Team Name :</h4>
      <input type="text" placeholder="enter team name" name="teamName" required="required" autofocus="autofocus">
     <h4>Abbrivation :</h4>
      <input type="text" placeholder="enter team name" name="abbr" required="required">
       <h4>Owner Name :</h4>
      <input type="text" placeholder="enter owner name" name="ownerName" required="required">
       <h4>Limit Max Age :</h4>
      <input type="number"  name="maxAge" required="required">
      <h4>Batting Avg :</h4>
      <input type="number" name="battingAvg">
      <h4>Wickets : </h4>
      <input type="number" name="wickets">
      <br>
      <input type="submit" value="Add Team"><br>
      </form>
</body>
</html>