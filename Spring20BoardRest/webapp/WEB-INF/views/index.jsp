<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head><title>홈페이지</title></head>
<body>
	<h1><spring:message code="greeting"/></h1>
	<div>현재 언어 : ${ pageContext.response.locale }</div>
	<a href="<c:url value='/board/board-list.do'/>">글 목록으로 이동</a><br>
	<a href="<c:url value='/admin/users-list.do'/>">사용자 목록으로 이동</a><br>
	<sec:authorize access="!hasRole('ADMIN') and !hasRole('USER')">
		<a href="<c:url value='/join.do'/>">회원 가입하기</a><br>
		<a href="<c:url value='/login.do'/>">로그인하기</a><br>
	</sec:authorize>
	<sec:authorize access="!hasRole('ADMIN') and hasRole('USER')">
		<a href="<c:url value='/users-modify.do'/>">회원정보변경</a><br>
		<a href="<c:url value='/logout.do'/>">로그아웃</a><br>
	</sec:authorize>
</body>
</html>