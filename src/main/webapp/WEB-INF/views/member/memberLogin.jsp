<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
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
		<h1><spring:message code="test" text="DefaultMessage"></spring:message>  Login Form</h1>
		<h1><spring:message code="test2" text="No Code"></spring:message></h1>
		
		<form action="./memberLogin" method="post">
		  <div class="form-group">
		    <label for="id">ID:</label>
		    <input type="text" value="admin" class="form-control" id="id" name="id">
		  </div>
		  <div class="form-group">
		    <label for="password">PASSWORD:</label>
		    <input type="password" value="admin" class="form-control" id="pw" name="pw">
		  </div>
		  
		  
		  <button type="submit" class="btn btn-default">Login</button>
		</form>
		
	</div>
		<h1>${mem}</h1>
</body>
</html>