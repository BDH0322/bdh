<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
			$("#idcheck").click(function(){
				
				var id=$("#id").val();
				$.ajax({
				type:"post",
				async: true,
				data:{"id":id},
				url:"idcheck2",
				success:function(res){	
					if(res=="ok") alert("가능");
					else alert("불가능");
				}
			})
		})
	})

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="membersave" method="post">
<table border="2" width="350px" align="center">
<caption>회원가입</caption>

<tr>
	<th>아이디</th> <td><input type="text" name="id" id="id">
	<input type="button" id="idcheck" value="id중복검사"></td>
</tr>

<tr>
	<th>패스워드</th> <td><input type="text" name="pw"></td>
</tr>

<tr>
	<th>이름</th> <td><input type="text" name="name"></td>
</tr>

<tr>
	<th>나이</th> <td><input type="text" name="age"></td>
</tr>

<tr style="text-align: center;">
	<td colspan="2"><input type="submit" value="전송">
	<input type="reset" value="취소"></td>
</tr>

</table>
</form>
</body>
</html>