<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
tr,td{
text-align: center;

}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="2" width="400px" align="center">
<caption>자료출력</caption>

<tr>
<th>id</th> <th>pw</th> <th>이름</th> <th>나이</th>
</tr>

<c:forEach items="${list }" var="my">
<tr>
<td>${my.id}</td>
<td>${my.pw}</td>
<td>${my.name}</td>
<td>${my.age}</td>
</tr>
</c:forEach>

</table>
</body>
</html>