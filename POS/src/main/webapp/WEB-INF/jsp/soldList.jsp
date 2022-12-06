<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>판매 정보</title>
</head>
<body>
	<jsp:include page="menu2.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">판매 정보</h1>
		</div>
	</div>
	<div class="container">
        <ul>
			<c:forEach var="item" items="${items}" varStatus="status">
					<li><b>${status.index + 1} : ${item.name}, ${item.quantity}, ${item.price}, ${item.date}</b></li>
			</c:forEach>
        </ul>
	</div>
</body>
</html>