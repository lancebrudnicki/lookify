<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<div Style="display: flex;">
		<a Style="margin: 10px;" href="http://localhost:8080/songs/new">Add New</a>
		<a Style="margin: 10px;" href="http://localhost:8080/search/topten">Top Songs</a>
 		<form Style="margin: 10px;" action="search" method="post">
		    <p>
		        <input type="text" name="artist">
		    	<input type="submit" value="New Search">
		    </p>
		</form>
	</div>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		<!-- this is our for loop to display the songs in our table -->
			<c:forEach items="${songs}" var="song">
				<tr>
					<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
					<td><c:out value="${song.rating}"/></td>
					<td>
						<form action="/delete/${song.id}" method="post">
		    				<input type="hidden" name="_method" value="delete">
		    				<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
			<!-- end the loop  -->
		</tbody>	
	</table>
	


</body>
</html>