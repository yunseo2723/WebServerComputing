<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>[예제8-2 2]Validation</title>
</head>
<body>
	<h3>입력에 성공했습니다.</h3>
	<%
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
	%>
	<p> 아 이 디 : <%=id %>
	<p> 비밀번호 : <%=passwd %>
</body>
</html>