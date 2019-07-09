<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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

<a href="./member/memberJoin">Member Join</a>
<a href="./member/memberLogin">Member Login</a>
<a href="./member/memberLogout">Member Logout</a>
</body>
</html>