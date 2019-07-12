<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="./qna/qnaList">QnA List</a>
<a href="./notice/noticeList">Notice List</a>

<c:choose>
	<c:when test="${not empty member}">
		<a href="./member/memberLogout">Member Logout</a>
		<c:if test="${member.grade eq 0}">
			<a href="./member/memberAdmin">Admin Page</a>
		</c:if>
	</c:when>
	<c:otherwise>
		<a href="./member/memberJoin">Member Join</a>
		<a href="./member/memberLogin">Member Login</a>
	</c:otherwise>
</c:choose>
<a href="./mall/productList">Product List</a>
<a href="./mall/productAdd">Product Add</a>
</body>
</html>