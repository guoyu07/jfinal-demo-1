<%--
  Created by IntelliJ IDEA.
  User: sd
  Date: 17/3/10
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${time}
${pk}
<form method="post" action="/save">
    <input name="userModel.userName"/>
    <input name="userModel.pwd"/>
    <input name="zero"/>
    <input type="submit" value="submit">
</form>
</body>
</html>
