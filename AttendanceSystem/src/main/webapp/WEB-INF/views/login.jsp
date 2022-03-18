<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<sp:form action="loginaction" method="post">
			<div class="form-group">
				<label>Username</label>
				<input type="text" name="username" placeholder="Enter Username" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label>Password</label>
				<input type="password" name="password" placeholder="Enter Password" class="form-control"/>
			</div>
			
			<div class="form-group">
				<input type="submit" value="Login" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
	</sp:form>
	</div>
</body>
</html>