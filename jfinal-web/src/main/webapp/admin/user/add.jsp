<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
<jsp:include page="/index.jsp"></jsp:include>
<div class="form_box">
    <form action="/user/save" method="post">
        <jsp:include page="_form.jsp"></jsp:include>
    </form>
</div>
</body>
</html>