<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 6/5/18
  Time: 2:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение товара</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<div id="content">
    <p style="color: red;">${errorString}</p>
    <c:if test="${not empty medicine}">
        <form method="POST" action="${pageContext.request.contextPath}/medicine/edit">
            <input type="hidden" name="id" value="${medicine.id_medicine}" />
            <table border="0">
                <tr>
                    <td>id</td>
                    <td style="color:red;">${medicine.id_medicine}</td>
                </tr>
                <tr>
                    <td>Название</td>
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
                    <td colspan = "2">
                        <input type="submit" value="Изменить" />
                        <a href="${pageContext.request.contextPath}/medicine/all">Отмена</a>
                    </td>
                </tr>
            </table>
        </form>
    </c:if>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
