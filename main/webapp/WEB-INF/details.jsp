<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
		<div style="display:flex">
			<h1>Title:</h1>
			<h1><c:out value="${song.title}"/></h1>
		</div>
		<div style="display:flex">
			<h1>Artist:</h1>
			<h1><c:out value="${song.artist}"/></h1>
		</div>
		<div style="display:flex">
			<h1>Rating:</h1>
			<h1><c:out value="${song.rating}"/></h1>
		</div>
	<form action="/delete/${song.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>
</body>
</html>