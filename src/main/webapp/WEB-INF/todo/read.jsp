<%--
  Created by IntelliJ IDEA.
  User: imchaewon
  Date: 2023/01/02
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Read</title>
</head>
<body>
    <div>
        <input type="text" name="tno" value="${dto.tno}" readonly/>
    </div>
    <div>
        <input type="text" name="title" value="${dto.title}" readonly/>
    </div>
    <div>
        <input type="date" name="dueDate" value="${dto.dueDate}" readonly/>
    </div>
    <div>
        <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} readonly/>
    </div>
    <div>
        <a href="/todo/modify?tno=${dto.tno}">Modify</a>
        <a href="/todo/list">List</a>
    </div>
</body>
</html>
