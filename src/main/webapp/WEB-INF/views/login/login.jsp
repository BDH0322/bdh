<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="logincheck" method="post">
<table border="2" width="350px" align="center">
<caption>로그인 화면</caption>

<tr>
	<th>아이디</th> <td><input type="text" name="id" id="id">
</tr>

<tr>
	<th>패스워드</th> <td><input type="text" name="pw"></td>
</tr>

<tr style="text-align: center;">
	<td colspan="2"><input type="submit" value="로그인">
	<input type="reset" value="취소"></td>
</tr>

</table>
</form>
</body>
</html>