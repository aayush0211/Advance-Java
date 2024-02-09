<%@page import="org.apache.taglibs.standard.lang.jstl.BooleanLiteral"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogOut Page</title>
</head>
<body>
      <h3 align="center" style="font-weight: bold;">Result</h3>
      <br>
      <h4>Hello ${param.fnm} ${param.lnm}</h4>
      <br>
      <h4><%= (List)request.getAttribute("list")!=null?"congratulation you are selected in "+(List)request.getAttribute("list"):"sorry your marks less then cut of marks for "
      %></h4>
      
</body>
</html>