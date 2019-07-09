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
		<div class="well">
			<h3>${dto.title}</h3>
		</div>
		<div class="well">
			<h3>${dto.writer}</h3>
		</div>
		<div class="jumbotron">
			${dto.contents}
		</div>
		<div>
			<c:forEach items="${dto.files}" var="fdto">
				<input type="button" title="${fdto.fname}" class="btn btn-danger down" value="${fdto.oname}">
			</c:forEach>
		</div>
		<div>
			<c:if test="${member.id eq dto.writer}">
				<a href="./${board}Update?num=${dto.num}" class="btn btn-primary">Update</a>
				<a href="./${board}Delete?num=${dto.num}" class="btn btn-primary">Delete</a>
			</c:if>
			<a href="./${board}Reply?num=${dto.num}" class="btn btn-primary">Reply</a>
			<a href="./${board}List" class="btn btn-primary">List</a>
		</div>
	</div>
	<div style="display: none;">
		<form id="downForm" action="../ajax/fileDownload" method="post">
			<input type="text" name="fname" id="fname">
			<input type="text" name="oname" id="oname">
			<input type="text" name="board" value="${board}">
		</form>
	</div>
	<script type="text/javascript">
		$(".down").click(function() {
			var fname = $(this).attr('title');
			var oname = $(this).val();
			$("#fname").val(fname);
			$("#oname").val(oname);
			$("#downForm").submit();
		});
	</script>
</body>
</html>