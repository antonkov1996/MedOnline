<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 6/6/18
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<div id="content">
    <p style="color: red;">${errorString}</p>

    <form method="POST" action="${pageContext.request.contextPath}/provider/add">
        <table border="0">
            <tr>
                <td>Производитель</td>
                <td><input type="text" name="prov_name" value="${provider.prov_name}" /></td>
            </tr>
            <tr>
                <td>Адрес</td>
                <td><input type="text" name="address" value="${provider.address}" /></td>
            </tr>
            <tr>
                <td>Город</td>
                <td><input type="text" name="city" value="${provider.city}" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Добавить" />
                    <a href="/provider/all">Отмена</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
