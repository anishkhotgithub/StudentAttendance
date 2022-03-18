<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<title>Insert title here</title>
<style>
		.myclass
		{
			margin:0 auto;
		}
	</style>
</head>
<body>
	
	<div class="">
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
 	 <a class="navbar-brand text-light" href="#">Navbar</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>

	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link text-light" href="/">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <sec:authorize access="!isAuthenticated()">
		      <li class="nav-item">
		        <a class="nav-link text-light" href="/faculty/login">Login</a>
		      </li>
		        
	      </sec:authorize>
	      
	      <sec:authorize access="hasAuthority('admin')">
		      <li class="nav-item">
		        <a class="nav-link text-light" href="/faculty/">User</a>
		      </li>
		       <li class="nav-item">
		        <a class="nav-link text-light" href="/student/studentdata">Students</a>
		      </li>
	      	<li class="nav-item">
		        <a class="nav-link text-light" href="/faculty/add">Register</a>
		      </li>
		   <li class="nav-item">
	        <a class="nav-link text-light" href="/import/">Upload Excel</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link text-light" href="/student/batchview">BatchView</a>
	      </li>
	      </sec:authorize>
	      <sec:authorize access="hasAuthority('teacher')">
	      <li class="nav-item">
	        <a class="nav-link text-light" href="/import/">Upload Excel</a>
	      </li>
	      
	      </sec:authorize>
	      
	      <sec:authorize access="isAuthenticated()">
	  <!--     <li class="nav-item">
	        <a class="nav-link text-light" href="/comment/">Posts</a>
	      </li>	 -->
	      
	      <li class="nav-item">
	        <a class="nav-link text-light" href="/faculty/logout">Logout</a>
	      </li>
	      </sec:authorize>
	    </ul>
	    <form class="form-inline my-2 my-lg-0">
	      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0 text-dark border-dark" type="submit">Search</button>
	    </form>
	    <Br>
  </div>
</nav>
</div>
</body>
</html>