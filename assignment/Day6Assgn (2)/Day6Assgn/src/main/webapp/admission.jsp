<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admission Page</title>
</head>
<body>
	<form action="authentication.jsp" method="post">
	<h3>CDAC Admission Form</h3>
	<br>
	<h4>First Name :</h4>
	<input type="text" name="fnm" placeholder="enter first name" required="required" autofocus="autofocus"/>
	<br>
	<h4>Last Name :</h4>
	<input type="text" name="lnm" placeholder="enter last name" required="required" />
	
	<br>
	<h4>Marks</h4>
	<input type="number" name ="marks" placeholder="enter marks" required="required"/>
    <br>
    <h4>Course</h4>
   <!--    <select name="course" size="1" required="required">
    <option  value="DAC">DAC</option>
    <option value="AI">AI</option>
    <option value="DITIS">DITIS</option>
    <option value="DESD">DESD</option>
    </select> -->
    <input type="checkbox" id="1" name="course1" value="DAC" />
    <label for="1">DAC</label>
     <input type="checkbox" id="2" name="course2" value="AI" />
    <label for="2">AI</label>
     <input type="checkbox" id="3" name="course3" value="DITIS" />
    <label for="3">DITIS</label>
     <input type="checkbox" id="4" name="course4" value="DESD" />
    <label for="4">DESD</label>
    <br>
    <input type="submit" value="Register"/>
    </form> 
</body>
</html>