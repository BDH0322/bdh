<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="booksave" method="post" enctype="multipart/form-data">
<table border="2" width="350px" align="center">
<caption>회원가입</caption>

<tr>
	<th>도서명</th> <td><input type="text" name="bname"></td>
</tr>

<tr>
	<th>저자</th> <td><input type="text" name="bwriter"></td>
</tr>

<tr>
	<th>도서정보</th> <td><input type="text" name="bmemo"></td>
</tr>

<tr>
	<th>도서가격</th> <td><input type="number" name="bprice"></td>
</tr>

<tr>
	<th>도서사진</th> <td><input type="file" name="bimage"></td>
</tr>

<tr>
	<th>출간일</th> <td><input type="date" name="bdate"></td>
</tr>

<tr style="text-align: center;">
	<td colspan="2"><input type="submit" value="전송">
	<input type="reset" value="취소"></td>
</tr>

</table>
</form>
</body>
</html>