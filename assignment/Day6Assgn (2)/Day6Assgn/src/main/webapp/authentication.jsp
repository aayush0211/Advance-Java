<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <% 
      String course1  = request.getParameter("course1");
     String course2  = request.getParameter("course2");
     String course3  = request.getParameter("course3");
     String course4  = request.getParameter("course4");
     int marks = Integer.parseInt(request.getParameter("marks"));
     List<String>list = new ArrayList<>();
     if(course1!=null && course1.equals("DAC") && marks>=85){
    	list.add(0, "DAC");	 
     }
      if(course2!=null&&course2.equals("AI") && marks>=80){
    	 list.add(1, "AI");	 
      }
     if(course3!=null&&course3.equals("DITIS") && marks>=65){
    	 list.add(2, "DITIS");	 
      }
      if(course4!=null&&course4.equals("DESD") && marks>=75){
    	 list.add(3, "DESD"); 
      }
    request.setAttribute("list", list);
   
     RequestDispatcher rd = request.getRequestDispatcher("logout.jsp");
     rd.forward(request, response);
     
     %>
     
     
</body>
</html>