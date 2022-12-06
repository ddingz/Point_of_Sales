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
		<div class="col-md-4 col-md-offset-4">
			<h3 class="form-signin-heading">아이디, 비밀번호 입력</h3>
			<form action="finishDeleteMember" method="post">
				<div class="form-group">
					<label for="inputUserName" class="sr-only">ID</label>
					<input type="text" class="form-control" placeholder="ID" name='id' value="${loginRequest.id}" required autofocus>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="sr-only">Password</label>
					<input type="password" class="form-control" placeholder="Password" name='pwd' value="${loginRequest.pwd}" required>
				</div>
				<button class="btn btn btn-lg btn-success btn-block" type="submit">관리자 제거</button>
			</form>
		</div>
	</div>
</body>
</html>