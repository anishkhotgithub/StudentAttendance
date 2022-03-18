<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<h4>${message}</h4>
	<table class="table table-striped table-bordered">
		<tr>
			<th>Rollno</th>
			<th>Name</th>
			<th>Email</th>
			<th>Batch</th>
			<th>Manipulation</th>
		</tr>
		<c:forEach items="${student}" var="student">
			<tr>
				<td>${student.rollno}</td>
				<td>${student.name}</td>
				<td>${student.email}</td>
				<td>${student.batch}</td>
				<sec:authorize access="hasAuthority('admin') and isAuthenticated()">
					<td>
						<a href="/student/editStudent/${student.id}" class="btn btn-warning">Edit</a>
						<a href="/student/delete/${student.id}" class="btn btn-danger">Delete</a> 
					</td>
				</sec:authorize>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>