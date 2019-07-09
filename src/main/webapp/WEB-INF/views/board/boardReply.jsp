<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp" />
<c:import url="../temp/summernote.jsp" />
</head>
<body>
	<div class="container">
		<h1>${board} Reply Form</h1>
		<form id="frm" action="./${board}Reply" method="post">
		    <input type="hidden" name="num" value="${num}">
		    <div class="form-group">
		      <label for="writer">Writer:</label>
		      <input type="text" class="form-control" id="writer" name="writer">
		    </div>
		    
		    <div class="form-group">
		      <label for="title">Title:</label>
		      <input type="text" class="form-control" id="title" name="title">
		    </div>
		    
		     <div class="form-group">
		      <label for="contents">Contents:</label>
		      <textarea class="form-control" rows="15" cols="" name="contents" id="contents"></textarea>
		    </div>
		    <input type="button" class="btn btn-default" value="write" id="write">
		  </form>
	
	</div>
	<script type="text/javascript" src="../resources/js/summernote.js"></script>
</body>
</html>