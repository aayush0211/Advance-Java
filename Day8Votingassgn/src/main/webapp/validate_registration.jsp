<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Valid Candidate</title>
</head>
<jsp:setProperty property="*" name="user"/>
<c:redirect url="${sessionScope.user.addNewCandidate()}.jsp"></c:redirect>
<body>
      
</body>
</html>