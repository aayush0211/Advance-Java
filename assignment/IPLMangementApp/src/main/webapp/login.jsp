<%@page import="beans.PlayerBean"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="centralized_err_handling.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn Page</title>
</head>
<!-- create bean instance action method[run time] -->
<jsp:useBean id="playerBean" class="beans.PlayerBean" scope="session"/>
<%! List<String>list; %>

<body>
      <form method = 'post' action='authenticate_player.jsp'>
      <h5> Choose a team: <select name = 'abbreviation'> 
      <% playerBean =(PlayerBean)session.getAttribute("playerBean");
      list = playerBean.getAllTeams();
      for(String s : list)
    	  out.write("<h5> <option value =' "+s+"'</option>"+s+"</h5>");
      %>
      </h5></select>
      <h5>Player First Name <input type='text' name ='firstName'/></h5>
      <h5>Player Last Name <input type='text' name ='lastName'/></h5>
      <h5>DOB <input type = 'date' name= 'dob' /></h5>
      <h5>Batting Avg <input type='number' name='battingAvg' /></h5>
      <h5>Wickets Taken <input type='text' name='wickets'/></h5>
      <h5><input type='submit' value='Add New Player'/></h5>
      </form>
</body>
</html>