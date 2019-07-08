<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp" />
</head>
<body>
	<div class="container">
		<h1>${board} Reply Page</h1>
		<form action="./${board}Reply" method="post">
			<input type="hidden" name="${num}">
			<div class="form-group">
				<label for="title">Title:</label> <input type="text" class="form-control" id="title" placeholder="Enter title" name="title"">
			</div>
			<div class="form-group">
				<label for="writer">Writer:</label> <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer">
			</div>
			<div class="form-group">
				<label for="contents">Contents:</label> <textarea class="form-control" rows="15" cols="" name="contents" placeholder="Enter contents"></textarea>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>