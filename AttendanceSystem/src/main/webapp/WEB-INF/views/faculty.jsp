<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	<table class="table table-striped table-bordered">
		<tr>
			<th>Userid</th>
			<th>Username</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Manipulation</th>
		</tr>
		<c:forEach items="${faculties}" var="faculty">
			<tr>
				<td>${faculty.userid}</td>
				<td>${faculty.username}</td>
				<td>${faculty.email}</td>
				<td>${faculty.mobile}</td>
				<sec:authorize access="hasAuthority('admin') and isAuthenticated()">
					<td>
						<a href="/faculty/edit/${faculty.userid}" class="btn btn-warning">Edit</a>
						<a href="/faculty/delete/${faculty.userid}" class="btn btn-danger">Delete</a> 
					</td>
				</sec:authorize>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>