<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>[예제14-3]Cookie</title>
</head>
<body>
   <%
        Cookie[] cookies = request.getCookies();
        
        for(int i=0; i< cookies.length; i++){
           cookies[i].setMaxAge(0);
           response.addCookie(cookies[i]);
        }
        response.sendRedirect("cookie02.jsp");
   %>
</body>
</html>