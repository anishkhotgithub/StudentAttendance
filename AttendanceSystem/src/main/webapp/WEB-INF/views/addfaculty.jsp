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
	<c:if test="${f==null}">
	<sp:form modelAttribute="faculty" action="/faculty/add" method="post">
			<div class="form-group">
				<label>Username</label>
				<sp:input path="username" placeholder="Enter Username" class="form-control"/>
				<sp:errors path="username" class="text-danger"></sp:errors>
			</div>
			
			<div class="form-group">
				<label>Email</label>
				<sp:input path="email" placeholder="Enter Email" class="form-control"/>
				<sp:errors path="email" class="text-danger"></sp:errors>
			</div>
			
			<div class="form-group">
				<label>Mobile</label>
				<sp:input path="mobile" placeholder="Enter Mobile" class="form-control"/>
				<sp:errors path="mobile" class="text-danger"></sp:errors>
			</div>
			
			<div class="form-group">
				<label>Password</label>
				<sp:password path="password" placeholder="Enter Password" class="form-control"/>
				<sp:errors path="password" class="text-danger"></sp:errors>
			</div>
			
			<div class="form-group">
				<input type="submit" value="Submit" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
	</sp:form>
	</c:if>
	
	<c:if test="${f!=null}">
	<sp:form modelAttribute="f" action="/faculty/update" method="post">
		<%-- 	<div class="form-group">
				<label>Userid</label>
				<sp:input path="userid" placeholder="Enter Userid" class="form-control" />
				<sp:errors path="userid" class="text-danger"></sp:errors>
			</div> --%>
			
			<div class="form-group">
				<label>Username</label>
				<sp:input path="username" placeholder="Enter Username" class="form-control" />
				<sp:errors path="username" class="text-danger"></sp:errors>
			</div>
			
			<div class="form-group">
				<label>Email</label>
				<sp:input path="email" placeholder="Enter Email" class="form-control"/>
				<sp:errors path="email" class="text-danger"></sp:errors>
			</div>
			
			<div class="form-group">
				<label>Mobile</label>
				<sp:input path="mobile" placeholder="Enter Mobile" class="form-control"/>
				<sp:errors path="mobile" class="text-danger"></sp:errors>
			</div>
			
			<div class="form-group">
				<sp:hidden path="authority" />
				<sp:hidden path="enabled"/>
				<sp:hidden path="password"/>
			</div>
			
			<div class="form-group">
				<input type="submit" value="Update" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
	</sp:form>
	</c:if>
	</div>
</body>
</html>