<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 6/6/18
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление класса</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<div id="content">
    <p style="color: red;">${errorString}</p>

    <form method="POST" action="${pageContext.request.contextPath}/class/add">
        <table border="0">
            <tr>
                <td>Имя класса</td>
                <td><input type="text" name="description" value="${classification.description}" /></td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit" />
                    <a href="/catalog">Отмена</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
