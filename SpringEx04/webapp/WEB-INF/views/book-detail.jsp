<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>도서 자세히 보기</title></head>
<body>
	<h1>도서 자세히보기</h1>
	<dl>
		<dt>도서번호</dt><dd>${ book.isbn }</dd>
		<dt>제목</dt><dd>${ book.title }</dd>
		<dt>저자</dt><dd>${ book.author }</dd>
		<dt>출판사</dt><dd>${ book.publisher }</dd>
		<dt>가격</dt><dd>${ book.price }</dd>
		<dt>책 설명</dt><dd>${ book.description }</dd>
	</dl>
	<a href="book-list.do">도서 목록으로 이동</a>
	<a href="book-modify.do?isbn=${ book.isbn }">수정하기</a>
	<a href="book-remove.do?isbn=${ book.isbn }">삭제하기</a>
</body>
</html>