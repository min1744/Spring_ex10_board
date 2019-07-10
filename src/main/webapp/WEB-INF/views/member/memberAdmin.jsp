<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp" />
<script type="text/javascript">
	$(function() {
		//search 값 남기기
		var kind = '${pager.kind}';
		$(".k").each(function() {
			if ($(this).val() == kind) {
				$(this).prop("selected", true);
			}
		});

		//checkAll button control
		$("#checkAll").click(function() {
			var checkAll = $(this).prop("checked");
			$(".check").prop("checked", checkAll);
		});

		//All check control
		$(".check").click(function() {
			var check = true;
			$(".check").each(function() {
				if (!$(this).prop("checked")) {
					check = false;
				}
			});
			$("#checkAll").prop("checked", check);
		});

		//MemberDelete button
		$("#btn").click(function() {
			//$("#frm").submit();
			var ids = [];
			$(".check").each(function() {
				if ($(this).prop("checked")) {
					ids.push($(this).val());
				}
			});
			//ajax로 배열을 전송하고자 할때 추가
			jQuery.ajaxSettings.traditional = true;

			$.ajax({
				url : "./memberAdmin",
				type : "POST",
				data : {
					id : ids
				},
				success : function(data) {
					console.log(data);
					location.reload();
				},
				error : function() {
					console.log('error');
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>Member Admin Page</h1>
	<!-- 회원들의 정보 -->
	<!-- ID, Email, Grade -->
	<div class="container">
		<form id="frm" action="./memberAdmin" class="form-inline">
			<div class="form-group col-xs-2">
				<select name="kind" class="form-control">
					<option value="1" class="k">ID</option>
					<option value="2" class="k">Email</option>
					<option value="3" class="k">Grade</option>
				</select>
			</div>
			<div class="form-group col-xs-2">
				<input type="text" class="form-control" value="${pager.search}"
					name="search">
			</div>
			<div class="form-group col-xs-2">
				<button class="form-control">Search</button>
			</div>
		</form>
		<div>
			<input type="button" value="MemberDelete" id="btn">
		</div>
		<form action="./memberAdmin" method="post">
			<table class="table table-hover">
				<tr>
					<td><input type="checkbox" id="checkAll"></td>
					<td>ID</td>
					<td>Email</td>
					<td>Grade</td>
				</tr>
				<c:forEach items="${list}" var="memberDTO" varStatus="i">
					<tr>
						<td><input type="checkbox" class="check" name="id"
							value="${memberDTO.id}"></td>
						<td>${memberDTO.id}</td>
						<td>${memberDTO.email}</td>
						<td>${memberDTO.grade}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
		<!-- Paging 처리 -->
		<ul class="pagination">
			<c:if test="${pager.curBlock>1}">
				<li><a
					href="./memberAdmin?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">BACK</a>
				</li>
			</c:if>

			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li><a
					href="./memberAdmin?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
				</li>
			</c:forEach>

			<c:if test="${pager.curBlock<pager.totalBlock}">
				<li><a
					href="./memberAdmin?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">NEXT</a>
				</li>
			</c:if>
		</ul>
	</div>
</body>
</html>