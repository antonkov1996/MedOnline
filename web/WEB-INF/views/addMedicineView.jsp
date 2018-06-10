<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 6/6/18
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить средство</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<div id="content">
    <p style="color: red;">${errorString}</p>

    <form method="POST" action="${pageContext.request.contextPath}/medicine/create">
        <table border="0">
            <tr>
                <td>Наименование препарата</td>
                <td><input type="text" name="medicine_name" value="${medicine.medicine_name}" /></td>
            </tr>
            <tr>
                <td>Производитель</td>
                <td><input type="text" name="id_provider" value="${medicine.id_provider}" /></td>
            </tr>
            <tr>
                <td>Цена</td>
                <td><input type="text" name="price" value="${medicine.price}" /></td>
            </tr>
            <tr>
                <td>Количество</td>
                <td><input type="text" name="quantity" value="${medicine.quantity}" /></td>
            </tr>
            <tr>
                <td>Класс</td>
                <td><input type="text" name="id_class" value="${medicine.id_class}" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Добавить" />
                    <a href="/medicine/add">Отмена</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
