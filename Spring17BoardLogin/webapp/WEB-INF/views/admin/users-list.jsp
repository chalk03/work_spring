<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>회원 목록</title></head>
<body>
	<h1>회원 목록</h1>
	<table>
		<thead>
			<tr>
				<th>사용자 번호</th>
				<th>이메일</th>
				<th>이름</th>
				<th>첨부파일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ list }" var="users">
				<tr>
					<td>${ users.no }</td>
					<td>${ users.email }</a></td>
					<td>${ users.name }</td>
					<%-- <td>${ users.attachment }</td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>