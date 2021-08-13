<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top Ten</title>
</head>
<body>
		<a href="http://localhost:8080/dashboard">Dashboard</a>
	<div style="display: flex;">
		<h1>Top Ten Songs:</h1>
	</div>
	<a href="/dashboard"></a>
		<table>
			<tbody>
			<!-- this is our for loop to display the songs in our table -->
				<c:forEach items="${songs}" var="song">
					<tr>
						<td><c:out value="${song.rating}"/></td>
						<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
						<td><c:out value="${song.artist}"/></td>
					</tr>
				</c:forEach>
				<!-- end the loop  -->
			</tbody>	
		</table>
</body>
</html>