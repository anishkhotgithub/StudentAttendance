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
	<sp:form modelAttribute="s" action="/student/update" method="post">
			<div class="form-group" hidden="hidden">
				<label>Userid</label>
				<sp:input path="id" placeholder="Enter Userid" class="form-control" />
			</div> 
			
			<div class="form-group">
				<label>Rollno</label>
				<sp:input path="rollno" placeholder="Enter Rollno" class="form-control" />
			</div>
			
			<div class="form-group">
				<label>Name</label>
				<sp:input path="name" placeholder="Enter Name" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label>Email</label>
				<sp:input path="email" placeholder="Enter email" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Batch</label>
				<sp:input path="batch" placeholder="Enter batch" class="form-control"/>
			</div>
			
			<div class="form-group">
				<input type="submit" value="Update" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
	</sp:form>
	</div>
</body>
</html>