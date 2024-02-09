<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Candidate</title>
</head>
<jsp:setProperty property="*" name="user"/>
<body>
     <h5>${sessionScope.user.message}</h5>
     <h3 align="center">City Election Candidate Registration</h3>

     <form action="validate_registration.jsp" method="post">
     Name :<br>
     <input type="text" name="fname" placeholder="enter candidate name" required="required" autofocus="autofocus" />
     <h6></h6>
     Party Name :<br>
     <input type="text" name="party" placeholder="enter party name" required="required"  />
     <h6></h6>
     <input type="submit" value="Register">
     </form>
</body>
</html>