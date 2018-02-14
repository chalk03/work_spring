<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>도서 등록</title></head>
<body>
	<h1>도서 등록</h1>
	<form action="book-add.do" method="post">
		<div>
			<label>도서제목<input type="text" name="title"></label>
		</div>
		<div>
			<label>저자<input type="text" name="author"></label>
		</div>
		<div>
			<label>출판사<input type="text" name="publisher"></label>
		</div>
		<div>
			<label>가격<input type="text" name="price"></label>
		</div>
		<div>
			<label>책설명</label>
			<textarea name="description"></textarea>
		</div>
		<input type="submit" value="도서 등록">
		<input type="reset" value="내용 지우기"><br>
		<a href="book-list.do">도서 목록으로 이동</a>
	</form>
</body>
</html>