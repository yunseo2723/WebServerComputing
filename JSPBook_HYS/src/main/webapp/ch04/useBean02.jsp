<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>[예제4-6]Action Tag</title>
</head>
<body>
	<jsp:useBean id ="bean" class="ch04.com.dao.Calculator" />
	<p> <%
			int m = bean.process(5);
			out.print("5의 3제곱 : " +m);
		%>
</body>
</html>