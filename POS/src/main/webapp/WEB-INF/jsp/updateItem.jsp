<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>물품 수정</title>
</head>
<body>
	<jsp:include page="menu2.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">물품 수정</h1>
		</div>
	</div>
	<div class="container" align="center">
		<div class="col-md-3">
    		<ul>
        		<c:forEach var="item" items="${items}">
					<li><b>${item.id} : ${item.name} ${item.quantity}개</b></li>
				</c:forEach>
    		</ul>
		</div>
	</div>
    <div class="container" align="center">
		<div class="col-md-4 col-md-offset-4">
			<h3 class="form-signin-heading">수정 물품 ID와 갯수를 입력하시오.</h3>
			<form action="finishUpdateItem" method="post">
				<div class="form-group">
					<label for="inputItemId" class="sr-only">Item ID</label>
					<input type="number" class="form-control" placeholder="ID" name='id' value="${updateRequest.id}" required autofocus>
				</div>
				<div class="form-group">
					<label for="inputQuantity" class="sr-only">Quantity</label>
					<input type="number" class="form-control" placeholder="Quantity" name='quantity' value="${updateRequest.quantity}" required>
				</div>
				<button class="btn btn btn-lg btn-success btn-block" type="submit">수정하기</button>
			</form>
		</div>
	</div>
</body>
</html>