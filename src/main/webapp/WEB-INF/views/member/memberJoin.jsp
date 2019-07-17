<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
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
		<form:form commandName="memberDTO" enctype="multipart/form-data">
		  <div class="form-group">
		    <label for="id">ID:</label>
		    <form:input cssClass="form-control" path="id"/>
		    <form:errors path="id"></form:errors> 
		  </div>
		  <div class="form-group">
		    <label for="password">PASSWORD:</label>
		    <form:password class="form-control" path="pw"/>
		  </div>
		  <div class="form-group">
		    <label for="password">PASSWORD:</label>
		    <form:password class="form-control" path="pw2"/>
		    <form:errors path="pw2"></form:errors>
		  </div>
		  <div class="form-group">
		    <label for="name">NAME:</label>
		    <form:input  class="form-control" path="name" />
		    <form:errors path="name"></form:errors>
		  </div>
		  <div class="form-group">
		    <label for="name">EMAIL:</label>
		    <form:input  class="form-control" path="email"/>
		    <form:errors path="email"></form:errors>
		  </div>
		  <div class="form-group">
		  	<input type="file" name="photo">
		  </div>
		  <form:button cssclass="btn btn-default">Join</form:button>
		</form:form>
	</div>
</body>
</html>