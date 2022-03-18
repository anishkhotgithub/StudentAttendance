<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container h-100">
	<div class="h-100">
		<div class="row h-100 justify-content-center align-items-center">
			<div class="col-sm-5">
				<h3>Upload Excel File to MySQL</h3>
				<form method="POST" enctype="multipart/form-data" id="fileUploadForm">
					<div class="form-group">
						<label class="control-label" for="uploadfile">Upload File:</label>
						<input type="file" class="form-control" id="uploadfile" placeholder="Upload File"  name="uploadfile"></input>
					</div>
					<button type="submit" class="btn btn-default" id="btnSubmit">Upload</button>
				</form>
				<div>
					<h4>${message}</h4>
					<a href="/file">Download Excel File from MySQL</a>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>