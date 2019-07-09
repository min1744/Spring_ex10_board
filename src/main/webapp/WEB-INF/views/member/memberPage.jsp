<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Page</h1>
	
	<h3>ID : ${member.id} </h3>
	<h3>Name : ${member.name} </h3>
	<h3>Email : ${member.email}</h3>
	
	<img alt="${member.memberFileDTO.oname}" src="../resources/member/${member.memberFileDTO.fname}">
	

</body>
</html>