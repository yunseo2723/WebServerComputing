<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ page isErrorPage="true" %>
<html>
<head>
<title>[예제11-3-오류]Exception</title>
</head>
<body>
	<p> 오류가 발생하였습니다.
	<p> 예외 : <%=exception %>
	<p> toString() : <%=exception.toString() %>
	<p> getClass().getName() : <%=exception.getClass().getName() %>
	<p> getMessage() : <%=exception.getMessage() %>
</body>
</html>