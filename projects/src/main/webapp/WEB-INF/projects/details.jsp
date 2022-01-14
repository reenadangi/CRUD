<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Details</title>
</head>
<body>
<div class="container">

<h3>Project Details:</h3>
<p>
	Name: <c:out value="${project.projectName}"/> 
</p>
<p>
	Description: <c:out value="${project.description}"/> 
</p>

<p>
	Created BY: <c:out value="${project.student.firstName}"/> 
</p>



</div>

</body>
</html>