<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>POS</title>
</head>
<body>
	<jsp:include page="menu2.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">POS</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<c:forEach var="item" items="${items}">
				<div class="col-md-2 border border-dark" align="center">
					<h5><b>${item.name}</b></h5>
					<h5><b>${item.price}원</b></h5>
					<h5><b>재고 : ${item.quantity}개</b></h5>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>