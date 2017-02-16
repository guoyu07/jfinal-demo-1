<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>简易demo</title>
</head>
<body>
<jsp:include page="/index.jsp"></jsp:include>
<h1>用户管理&nbsp;&nbsp;
    <a href="/user/add">创建用户</a>
</h1>
<div class="table_box">
    <table class="list">
        <thead>
        <tr>
            <th>主键</th>
            <th>用户名</th>
            <th>密码</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>创建日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <c:forEach items="${userList}" var="i">
            <tr>
                <td>${i.id}</td>
                <td>${i.userName}</td>
                <td>${i.pwd}</td>
                <td>
                    <c:if test="${i.sex eq true}">
                        男
                    </c:if>
                    <c:if test="${i.sex eq false}">
                        女
                    </c:if>
                </td>
                <td>${i.birthDate}</td>
                <td>${i.createDate}</td>
                <td>
                    <a href="/user/delete/${i.id}">删除</a>
                    <a href="/user/edit/${i.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
