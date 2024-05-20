<%@ page contentType = "text/html; charset=UTF-8" %>
<html>
<head>
<title>[예제11-6-예외]Exception</title>
</head>
<body>
	<p> 잘못된 데이터가 입력되었습니다.
	<p> <%=" 숫자1 : " + request.getParameter("num1") %>
	<p> <%=" 숫자2 : " + request.getParameter("num2") %>
</body>
</html>