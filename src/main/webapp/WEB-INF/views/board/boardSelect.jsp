<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"/>
</head>
<body>
	<div class="container">
		<div class="well">
			<h3>${dto.title}</h3>
		</div>
		<div class="well">
			<h3>${dto.writer}</h3>
		</div>
		<div class="jumbotron">
			${dto.contents}
		</div>
		<c:forEach items="${dto.files}" var="fdto"><!-- dto.files -->
			<a href="../resources/${board}/${fdto.fname}">${fdto.oname}</a>
		</c:forEach>
		<div>
			<a href="./${board}Update?num=${dto.num}" class="btn btn-primary">Update</a>
			<a href="./${board}Delete?num=${dto.num}" class="btn btn-primary">Delete</a>
			<a href="./${board}Reply?num=${dto.num}" class="btn btn-primary">Reply</a>
			<a href="./${board}List" class="btn btn-primary">List</a>
		</div>
	</div>
</body>
</html>