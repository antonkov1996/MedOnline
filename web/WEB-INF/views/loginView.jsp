<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/26/18
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<div id="content">
<h3>Вход</h3>

<p style="color: red;">${errorString}</p>

<form method="POST" action="${pageContext.request.contextPath}/login">
    <input type="hidden" name="redirectId" value="${param.redirectId}" />
    <table border="0">
        <tr>
            <td>Ваша почта</td>
            <td><input type="text" name="email" value= "" /> </td>
        </tr>
        <tr>
            <td>Пароль</td>
            <td><input type="password" name="password" value= "" /> </td>
        </tr>

        <tr>
            <td colspan ="2">
                <input type="submit" value= "Применить" />
                <a href="${pageContext.request.contextPath}/">Отмена</a>
            </td>
        </tr>
    </table>
    <a href="/register">Регистрация</a>
</form>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
