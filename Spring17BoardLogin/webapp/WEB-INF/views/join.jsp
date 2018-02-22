<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>회원 가입하기</title></head>
<body>
	<h1>회원 가입하기</h1>
	<form action="<c:url value='/join.do'/>" method="post" enctype="multipart/form-data">
		<label>이메일 <input type="email" name="email"></label><br>
		<label>비밀번호 <input type="password" name="password"></label><br>
		<label>이름 <input type="text" name="name"></label><br>
		<label>첨부 파일 <input type="file" name="attachment"></label><br><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>