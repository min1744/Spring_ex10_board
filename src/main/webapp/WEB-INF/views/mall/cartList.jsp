<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"/>
</head>
<body>
	<!-- 타이틀, 수량, 가격, 총가격 -->
	<div class="container">
		<table class="table table-hover">
			<tr>
				<td>전체선택<input type="checkbox" id="checkAll"></td>
				<td>제품명</td>
				<td>Option</td>
				<td>수량</td>
				<td>가격</td>
				<td>합계</td>
			</tr>
			<c:forEach items="${cartList}" var="cart" varStatus="i">
				<tr>
					<td><input type="checkbox" class="check"></td>
					<td>${cart.title}</td>
					<td>${cart.contents}</td>
					<td><input type="number" id="amount${i.index}" class="amount" value="${cart.amount}"><input title="amount${i.index}" data-num="${cart.num}" class="updateCart" type="button" value="수정"> </td>
					<td>${cart.price}</td>
					<td>${cart.amount * cart.price}</td>
					<td><input type="hidden" id="num" value="n${i.index}"></td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<button class="btn btn-danger" id="deleteBtn">Delete</button>
		</div>
	</div>
	<script type="text/javascript">
		$(".checkAll").click(function() {
			var check = $(this).val();
			$(".check").prop("checked", check);
		});
		
		$(".check").click(function() {
			var check = true;
			$(".check").each(function() {
				if (!$(this).prop("checked")) {
					check = false;
				}
			});
			$("#checkAll").prop("checked", check);
		});
		
		$("#deleteBtn").click(function() {
			var nums = [];
			$(".check").each(function() {
				if ($(this).prop("checked")) {
					ids.push($(this).val());
				}
			});
			//ajax로 배열을 전송하고자 할때 추가
			jQuery.ajaxSettings.traditional = true;

			$.ajax({
				url : "./cartList",
				type : "POST",
				data : {
					num : nums
				},
				success : function(data) {
					location.reload();
				},
				error : function() {
					console.log('error');
				}
			});
		});
		
		$(".updateCart").click(function() {
			var amount = $(this).prev().val();
			var num = $(this).attr("data-num");
			
			$.ajax({
				url:"./cartUpdate",
				type:"POST",
				data:{
					num:num,
					amount:amount
				},
				success:function(data){
					//data : 0 이면 실패, 1 이면 성공
					var result = confirm("정말 수정하시겠습니까?");
					if(result){
						if(data == '1'){
							alert('장바구니 수정 성공');
							location.reload();
						} else {
							alert('장바구니 수정 실패');
						}
					}
				}
			});
		});
	</script>
</body>
</html>