<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>도서 삭제 확인화면</title></head>
<body>
	<h1>도서 삭제 확인</h1>
	<p>정말로 ${ isbn }번 도서를 삭제하겠습니까?</p>
	<form action="<c:url value='/book/book-remove.do'/>" method="post">
		<input type="hidden" name="isbn" value="${ isbn }">
		<input type="submit" value="삭제하기">
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	</form>
	<a href="<c:url value='/book/book-list.do'/>">도서 목록으로 이동</a>
</body>
</html>