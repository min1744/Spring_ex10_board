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
		<h1>${board} Write Form</h1>
		<form id="frm" action="./${board}Write" method="post" enctype="multipart/form-data">
		    
		    <div class="form-group">
		      <label for="writer">Writer:</label>
		      <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer">
		    </div>
		    
		    <div class="form-group">
		      <label for="title">Title:</label>
		      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
		    </div>
		    
		     <div class="form-group">
		      <label for="contents">Contents:</label>
		      <textarea class="form-control" id="contents" rows="15" cols="" name="contents"></textarea>
		    </div>
		    
		    <div>
		    	<input type="button" class="btn btn-info" id="add" value="ADD FILE">
		    	<div id="files"></div>
		    </div>
		    
		    <input type="button" id="write" class="btn btn-default" value="Write">
		  </form>
	
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
			//$(this).remove();
			count--;
		});
	
	</script>
	

</body>
</html>