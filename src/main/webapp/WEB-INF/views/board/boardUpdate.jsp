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
		<h1>${board} Update Form</h1>
		<form id="frm" action="./${board}Update" method="post" enctype="multipart/form-data">
		    <input type="hidden" name="num" value="${dto.num}">
		    <div class="form-group">
		      <label for="writer">Writer:</label>
		      <input type="text" class="form-control" id="writer" value="${dto.writer}" name="writer" readonly="readonly">
		    </div>
		    
		    <div class="form-group">
		      <label for="title">Title:</label>
		      <input type="text" class="form-control" id="title" value="${dto.title}" name="title">
		    </div>
		    
		     <div class="form-group">
		      <label for="contents">Contents:</label>
		      <textarea class="form-control" rows="15" cols="" name="contents" id="contents"></textarea>
		    </div>
		    
		    <div>
		    	<c:forEach items="${dto.files}" var="fdto">
		    		 <p>${fdto.oname}: <span id="${fdto.fnum}" title="${fdto.fname}" class="glyphicon glyphicon-remove fdel"></span></p>  
		    	</c:forEach>
		    </div>
		     <div>
		    	<input type="button" class="btn btn-info" id="add" value="ADD FILE">
		    	<div id="files"></div>
		    </div>
		    <input type="button" class="btn btn-default" value="update" id="write">
		  </form>
	</div>
	
	<script type="text/javascript" src="../resources/js/summernote.js"></script>
	<script type="text/javascript">
		$("#contents").summernote('code', '${dto.contents}');
		
		var count=${dto.files.size()}
		
		//파일을 DB에서 삭제 ajax
		$(".fdel").click(function() {
			var check = confirm("삭제 하시겠습니까? 복구 불가능");
			var id = $(this).attr("id");
			var title = $(this).attr("title");
			var select = $(this);
			if(check){
				//$.get(url, callBack)
				//$.post(url, {}, callback)
				$.ajax({
					url:"../ajax/fileDelete",
					type:"POST",
					data:{
						fnum:id,
						fname:title,
						board:'${board}'
					},
					success:function(data){
						data=data.trim();
						if(data=='1'){
							select.parent().remove();
							count--;
							select.remove();
						}else {
							alert("File Delete Fail");
						}
					}
				});
			}
		});
		
	
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