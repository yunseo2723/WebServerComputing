<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>[예제5-1-1]Implicit Objects</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String userid=request.getParameter("id");
		String password=request.getParameter("passwd");
	%>
	<p> 아이디 : <%=userid %>
	<p> 비밀번호 : <%=password %>
</body>
</html>