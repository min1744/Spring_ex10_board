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
		<h1>${board} Update Page</h1>
		<form action="./${board}Update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="${dto.num}">
			<div class="form-group">
				<label for="title">Title:</label> <input type="text" class="form-control" id="title" placeholder="Enter title" name="title" value="${dto.title}">
			</div>
			<div class="form-group">
				<label for="writer">Writer:</label> <input type="text" class="form-control" id="writer" value="${dto.writer}" name="writer">
			</div>
			<div class="form-group">
				<label for="contents">Contents:</label> <textarea class="form-control" rows="15" cols="" name="contents" placeholder="Enter contents">${dto.contents}</textarea>
			</div>
			<div>
				<c:forEach items="${dto.files}" var="fdto">
					<!-- input type file은 readonly -->
					<p>${fdto.oname}: <span id="${fdto.fnum}" title="${fdto.fname}" class="glyphicon glyphicon-remove fdel"></span></p>
				</c:forEach>
			</div>
			<div>
				<input type="button" id="add" value="ADD FILE" class="btn btn-info">
				<div id="files"></div>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
	<script type="text/javascript">
	var count = ${dto.files.size()};
	
	//파일을 DB에서 삭제 ajax
	$(".fdel").click(function() {
		var check = confirm("정말 삭제하시겠습니까?");
		var id = $(this).attr("id");
		var title = $(this).attr("title");
		var select = $(this);
		if(check){
			//$.get(url, callback)
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
					data = data.trim();
					if(data == '1'){
						select.parent().remove();
						//select.remove();
					} else {
						alert("File Delete Fail");
					}
				}
			});
		}
	});
	
		$("#add").click(function() {
			if(count < 5){
				var result = '<input type="file" name="f1" class="form-control"><span class="del">X</span>';
				$("#files").append(result);
				count++;
			} else {
				alert("첨부파일은 최대 5개만 가능합니다.");
			}
		});
		
		$("#files").on("click", ".del", function() {
			$(this).prev().remove();
			$(this).remove();
			count--;
		});
	</script>
</body>
</html>