<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<h4>Hello ${sessionScope.user.userDetails.firstName}!</h4>
	<h4>Vote to any one candidate....</h4>
	<form action="logout.jsp" method="post">
	<h5><c:forEach var="cnd" items="${sessionScope.user.getAllCandidate()}" >
	<input type="radio" name="cndId" value="${cnd.candidateId}" />Name=${cnd.candidateName}   Party=${cnd.party}
	<br>
	</c:forEach></h5>
	<h5><input type="submit" value="Vote"></h5>
	</form>
</body>
</html>