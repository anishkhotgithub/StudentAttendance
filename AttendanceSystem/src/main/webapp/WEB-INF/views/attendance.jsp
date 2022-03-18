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
	<sp:form action="" modelAttribute="attendance" >
	<h4>${message}</h4>
	<table class="table table-striped table-bordered">
		<tr>
			<th>Rollno</th>
			<th>Name</th>
			<th>Attendance</th>
		</tr>
		<c:forEach items="${student}" var="student">
			<tr>
				<td>${student.rollno}</td>
				<td>${student.name}</td>
				<sec:authorize access="hasAuthority('admin') and isAuthenticated()">
					<td>
						<label>Present</label>
						<sp:radiobutton path="${student.rollno}" id="P" value="P"/>
						<label>Absent</label>
						<sp:radiobutton path="${student.rollno}" id="A" value="A"/>
					</td>
				</sec:authorize>
			</tr>
		</c:forEach>
	</table>
	<center>
	<sp:input type="date" path="date" id="date"/>
	<input type="submit" value="Submit">
	</center><br><br><br>
	</sp:form>
	</div>
</body>
</html>