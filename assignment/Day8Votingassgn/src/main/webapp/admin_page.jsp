<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<%--session.getAttribute("user").getUserDetails().getFirstName() sent to clnt --%>
	<h5>Hello , ${sessionScope.user.userDetails.firstName}
		${sessionScope.user.userDetails.lastName}, logged in under
		${sessionScope.user.userDetails.role} role</h5>
		<h5>Party wise votes : </h5>
		<h5>${sessionScope.user.partywiseVotes}</h5>
		<h5>Top 2 Candidates are : </h5>
		 <c:forEach var="candidate" items="${sessionScope.user.getTop2Candidates()}">
		         ${candidate.toString()}
		         <br>
		         </c:forEach>
	<h5>All Candidates are : </h5>
		 <c:forEach var="candidate" items="${sessionScope.user.getAllCandidate()}">
		         ${candidate.toString()}
		         <br>
		         </c:forEach>
		   
	<h5>
		<a href="logout.jsp">Admin Log Out</a>
	</h5>
</body>
</html>