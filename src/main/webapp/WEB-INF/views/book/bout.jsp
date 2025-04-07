<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2" width="400px" align="center">
<caption>책 자료 출력</caption>

<tr>
<th>도서번호</th> <th>도서명</th> <th>저자</th> <th>도서내용</th> <th>도서가격</th> <th>도서표지</th> <th>선택사항</th>
</tr>

<c:forEach items="${lisg}" var="my">
<tr>
<td>${my.bnumber }</td>
<td>${my.bname }</td>
<td>${my.bwriter }</td>
<td>${my.bmemo }</td>
<td>${my.bprice }</td>
<td><img alt="" src="./image/${my.bimage}"> </td>
<td> <a href="bookdelete?bnum=${my.bnumber}">삭제</a>
<a href="modify?num=${my.bnumber}">수정</a> </td>
</tr>
</c:forEach>

</table>
</body>
</html>