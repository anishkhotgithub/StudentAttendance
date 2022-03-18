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
		<div class="row">
		<div class="card m-5" style="width: 18rem;">
			<a href="/attendance/Bscit">
  			<img class="card-img-top" src="https://cdn.osxdaily.com/wp-content/uploads/2017/10/folder-ios-files-app.jpg" alt="BSCIT">
  			</a>
  			<div class="card-body">
    			<p class="card-text">BSCIT</p>
  			</div>
		</div>
		<div class="card m-5" style="width: 18rem;">
			<a href="/attendance/BMS">
  				<img class="card-img-top" src="https://cdn.osxdaily.com/wp-content/uploads/2017/10/folder-ios-files-app.jpg" alt="BMS">
  			</a>
  			<div class="card-body">
    			<p class="card-text">BMS</p>
  			</div>
		</div>
		</div>
	</div>
</body>
</html>