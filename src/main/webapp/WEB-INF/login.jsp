<%--
  Created by IntelliJ IDEA.
  User: imchaewon
  Date: 2023/01/04
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<c:if test="${param.result == 'error'}">
 <h1>Login Error</h1>
</c:if>

    <form action="/login" method="post">
        <div>
            <input type="text" name="userid" placeholder="아이디"/>
        </div>
        <div>
            <input type="password" name="userpw" placeholder="password"/>
        </div>
        <div>
            <label><input type="checkbox" name="auto" />로그인유지</label>
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
    </form>
</body>
</html>
