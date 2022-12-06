<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="utf-8">
<title>관리자 삭제</title>
</head>
<body>
	<jsp:include page="menu1.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">관리자 삭제</h1>
		</div>
	</div>
	<div class="container" align="center">
		<div class="col-md-5 col-md-offset-5">
			<h3 class="form-signin-heading">${loginRequest.id} 관리자가 삭제 되었습니다.</h3>
		</div>
	</div>
</body>
</html>