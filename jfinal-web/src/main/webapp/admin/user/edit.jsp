<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
<jsp:include page="/index.jsp"></jsp:include>
<div class="form_box">
    <form action="/user/update" method="post">
        <jsp:include page="_form.jsp"></jsp:include>
    </form>
</div>
</body>
</html>