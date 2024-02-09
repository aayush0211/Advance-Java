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
	<h4>Hello ${sessionScope.user.userDetails.firstName}</h4>
	<h5>
	<c:choose>
	<c:when test="${sessionScope.user.userDetails.getRole().equals('admin')}">
		        
				${sessionScope.user.userDetails.role} logged out....
		</c:when>
		<c:when test="${sessionScope.user.userDetails.isVotingStatus()}">
		        Already voted!!!!!
				${sessionScope.user.userDetails.role} logged out....
		</c:when>
		<c:when test="${sessionScope.user.userDetails.isVotingStatus()==false}">
		<jsp:setProperty property="*" name="user"/>
				${sessionScope.user.updateVotingStatus()}
				${sessionScope.user.incrementVotes()}
				${sessionScope.user.userDetails.role} logged out....
		</c:when>
		
	</c:choose>
	</h5>
<%-- 	 ${pageContext.session.invalidate()} --%>
	
</body>
</html>