<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ page errorPage = "errorPage_error.jsp" %>
<html>
<head>
<title>[예제11-1]Exception</title>
</head>
<body>
	name 파라미터 : <%=request.getParameter("name").toUpperCase() %>
</body>
</html>