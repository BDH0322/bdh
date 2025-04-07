<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<header>
<h2>로그인-id중복검사 예제</h2>
</header>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="main.jsp">퇴근</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">회원관리<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="minput">1.회원가입</a></li>
          <li><a href="mout">2.회원자료출력</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">도서관리<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="binput">1.도서자료입력</a></li>
          <li><a href="bout">2.도서자료출력</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
    <c:choose>
    	<c:when test="${loginstate==true }">
    		<li><a href="#"><span class="glyphicon glyphicon-user"></span> ${id} 반갑습니다.</a></li>
      		<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
    	</c:when>
    	
    	<c:otherwise>
    		<li><a href="minput"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>
     		<li><a href="login"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
    	</c:otherwise>
    </c:choose>
    </ul>
    
  </div>
</nav>
</body>
</html>