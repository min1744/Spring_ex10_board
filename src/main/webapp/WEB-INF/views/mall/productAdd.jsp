<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	/* summernote class name */
	.note-editalbe{
		height: 300px;
	}
</style>
<c:import url="../temp/boot.jsp"/>
<c:import url="../temp/summernote.jsp"/>
</head>
<body>
	<div class="container">
		<!-- method 디폴트가 POST -->
		<!-- action 안쓰면 URL 주소 -->
		<form:form commandName="productVO" enctype="multipart/form-data">
			<div class="form-group">
				<label for="category">Category:</label>
				<form:select path="category" cssClass="form-control">
					<option> -- 선택 -- </option>
					<form:options items="${list}" cssClass="form-control"/>
				</form:select>
			</div>
			<div class="form-group">
				<label for="title">Title:</label>
				<form:input path="title" cssClass="form-control" id="title"/>
			</div>
			<div class="form-group">
				<label for="price">price:</label>
				<form:input path="price" cssClass="form-control" id="price"/>
			</div>
			<div class="form-group">
				<label for="subContents">SubContents:</label>
				<form:textarea path="subContents" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<label for="mainContents">MainContents:</label>
				<form:textarea id="contents" path="mainContents" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<label for="amount">Amount:</label>
				<form:input path="amount" cssClass="form-control" id="amount"/>
			</div>
			<%-- <div class="form-group">
				<label for="options">Option:</label>
				<form:input path="optionsVOs.optionsVO.contents" cssClass="form-control" id="options"/>
			</div> --%>
			<!-- <div class="form-group">
				<input type="button" class="btn btn-info" id="addOption" value="ADD Option">
		    	<div id="options"></div>
			</div> -->
			<div>
		    	<input type="button" class="btn btn-info" id="add" value="ADD FILE">
		    	<div id="files"></div>
		    </div>
		    <button>Write</button>
		</form:form>
	</div>
	<script type="text/javascript" src="../resources/js/summernote.js"></script>
	<script type="text/javascript">
		var count=0;
		$("#add").click(function() {
			if(count<5){
				var result ='<div class="input-group col-xs-3"><input type="file" name="f1" class="form-control"><span class="input-group-addon"><i class="glyphicon glyphicon-remove del"></i></span> </div>';
				$("#files").append(result);
				count++;
			}else {
				alert("첨부파일은 최대 5개만 가능합니다.");
			}
		});
		
		$("#files").on("click", ".del", function() {
			$(this).parent().parent().remove();
			count--;
		});
</script>
</body>
</html>