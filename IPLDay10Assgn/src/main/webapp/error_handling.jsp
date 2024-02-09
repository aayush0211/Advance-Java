<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
        <h4>${exception.message}</h4>
         <h4>${exception}</h4>
          <h4>${pageContext.errorData.statusCode}</h4>
         
          
</body>
</html>