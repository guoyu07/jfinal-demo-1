<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<fieldset class="solid">
    <legend>创建用户</legend>
    <input type="hidden" name="user.id" value="${user.id}"/>
    <div>
        <label>用户名</label>
        <input type="text" name="user.userName" value="${user.userName}"/>${userNameMsg}
    </div>
    <div>
        <label>密码</label>
        <input type="password" name="user.pwd" value="${user.pwd}">${pwdMsg}
    </div>
    <div>
        <label>性别</label>
        <br><input type="radio" name="user.sex" value="1">男
        <br><input type="radio" name="user.sex" value="0">女
        ${sexMsg}
    </div>
    <div>
        <label>生日</label>
        <input type="date" name="user.birthDate" value="${user.birthDate}">${birthDateMsg}
    </div>
    <div>
        <label>&nbsp;</label>
        <input value="提交" type="submit">
    </div>
</fieldset>