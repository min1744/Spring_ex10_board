<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Member Join Form</h1>
		
		<form action="./memberJoin" method="post" enctype="multipart/form-data">
		  <div class="form-group">
		    <label for="id">ID:</label>
		    <input type="text" class="form-control" id="id" name="id">
		  </div>
		  <div class="form-group">
		    <label for="password">PASSWORD:</label>
		    <input type="password" class="form-control" id="pw" name="pw">
		  </div>
		  <div class="form-group">
		    <label for="name">NAME:</label>
		    <input type="text" class="form-control" id="name" name="name">
		  </div>
		  <div class="form-group">
		    <label for="name">EMAIL:</label>
		    <input type="email" class="form-control" id="email" name="email">
		  </div>
		  
		  
		  <div class="form-group">
		  	<input type="file" name="photo">
		  </div>
		  
		  <button type="submit" class="btn btn-default">Join</button>
		</form>
		
	</div>

</body>
</html>