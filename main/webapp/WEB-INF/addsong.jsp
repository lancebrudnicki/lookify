<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Song</title>
</head>
<body>
	
	<div>
		<a href="http://localhost:8080/dashboard">Dashboard</a>
	</div>
	<div>
		<form:form action="/songs/add" method="post" modelAttribute="song">
		    <p>
		        <form:label path="title">Title</form:label>
		        <form:errors path="title"/>
		        <form:input path="title"/>
		    </p>
		    <p>
		        <form:label path="artist">Artist</form:label>
		        <form:errors path="artist"/>
		        <form:input path="artist"/>
		    </p>
		    <p>
		        <form:label path="rating">Rating(1-10)</form:label>
		        <form:errors path="rating"/>
		        <form:input type ="number" path="rating"/>
		    </p>  
		    <input type="submit" value="Add Song"/>
		</form:form>
	</div>

</body>
</html>