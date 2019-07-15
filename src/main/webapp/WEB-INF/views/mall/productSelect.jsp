<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
		    			<!-- Indicators -->
		    			<ol class="carousel-indicators">

		    				<c:forEach items="${product.nailVOs}" var="images" varStatus="i">
		    					<c:choose>
			      					<c:when test="${i.index eq 0}">
			      						<li data-target="#myCarousel" data-slide-to="${i.index}" class="active"></li>
			      					</c:when>
			      					<c:otherwise>
			      						<li data-target="#myCarousel" data-slide-to="${i.index}"></li>
			      					</c:otherwise>
			   				  </c:choose>
		    				
		    				</c:forEach>
		    				
		    				
		  				</ol>
		
		    <!-- Wrapper for slides -->
		    <div class="carousel-inner">

		      <c:forEach items="${product.nailVOs}" var="images" varStatus="i"> 
			      <c:choose>
			      	<c:when test="${i.index eq 0}">
			      		<div class="item  active">
			      	</c:when>
			      	<c:otherwise>
			      		 <div class="item">
			      	</c:otherwise>
			      </c:choose>
			     
			        <img src="../resources/mall/${images.fname}" style="width:100%;">
			      </div>
			     </c:forEach>
		     </div>
		
		    <!-- Left and right controls -->
		    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
		      <span class="glyphicon glyphicon-chevron-left"></span>
		      <span class="sr-only">Previous</span>
		    </a>
		    <a class="right carousel-control" href="#myCarousel" data-slide="next">
		      <span class="glyphicon glyphicon-chevron-right"></span>
		      <span class="sr-only">Next</span>
		    </a>
		  </div>
			</div>
			<div class="col-md-6">
				<div class="well">${product.title}</div>
				
				<div class="well">
					<form>
						<input type="hidden" id="pid" name="pid" value="${product.pid}">
						<select name="options" id="options">
							<c:forEach items="${product.optionsVOs}" var="optionsVO">
								<option value="${optionsVO.num}">${optionsVO.contents}</option>
							</c:forEach>
						</select>
						<input type="number" name="amount" id="amount" min="0">
					</form>					
				</div>
				
				<div>
					<button class="btn btn-primary" id="addCart">장바구니</button>
					<button class="btn btn-danger">바로구매</button>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="jumbotron">
				${product.mainContents}
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$("#addCart").click(function() {
			var pid = $("#pid").val();
			var options = $("#options").val();
			var amount = $("#amount").val();
			var id = '${member.id}';
			
			$.ajax({
				url:"../cart/cartWrite",
				type:"POST",
				data:{
					pid:pid,
					options:options,
					amount:amount,
					id:id
				},
				success:function(data){
					//data : 0 이면 실패, 1 이면 성공
					if(data == '1'){
					var result = confirm("장바구니 이동?");
						if(result){
							location.href="../cart/cartList";
						}
					}else {
						alert('장바구니 등록 실패');
					}
				}
			});
		});
	</script>
</body>
</html>