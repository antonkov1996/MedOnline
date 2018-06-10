<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/22/18
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${medicine.medicine_name}</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<div id="content">
    <p style="color: red;">${errorString}</p>
    <h2>Припарат ${medicine.medicine_name}</h2>
    <ul>
        <li>Наименование: ${medicine.medicine_name}</li>
        <li>Производитель:
            <form method="post" action="/provider">
                <input type="hidden" name="id" value="${provider.id_provider}"/>
                <input type="submit" class="linkButton" value="${provider.prov_name}">
            </form>
        </li>
        <li>Цена: ${medicine.price}</li>
        <li>Осталось: ${medicine.quantity}</li>
        <li>Из группы:
            <form method="post" action="/catalog/class">
                <input type="hidden" name="id" value="${classification.id_class}"/>
                <input type="submit" class="linkButton" value="${classification.description}">
            </form>
    </ul>

    <c:if test="${not empty isLogined}">
        <c:choose>
            <c:when test="${medicine.quantity=='0'}">
                Извините товар закончился:(
            </c:when>
            <c:otherwise>
                <form method="post" action="${pageContext.request.contextPath}/medicine/add">
                    <input type="hidden" name="redirectId" value="${param.redirectId}"/>
                    <input type="hidden" name="id" value="${medicine.id_medicine}"/>
                    <input type="number" name="q" max="${medicine.quantity}" min="1" value="1" style="width:33px">
                    <input type="submit" value="Применить"/>
                </form>

            </c:otherwise>
        </c:choose>
    </c:if>
    <c:if test="${empty isLogined}">
        <p>Вы не вошли!</p><a href="/login">Войти</a>
    </c:if>


    <br>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
