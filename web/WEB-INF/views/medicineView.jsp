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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="container">
    <p style="color: red;">${errorString}</p>
    <h2>Препарат ${medicine.medicine_name}</h2>
    <ul>
        <li>Наименование: ${medicine.medicine_name}</li>
        <li>Производитель:
            <form method="post" action="/provider">
                <input type="hidden" name="id" value="${provider.id_provider}"/>
                <input type="submit" class="btn btn-primary"  value="${provider.prov_name}">
            </form>
        </li>
        <li>Цена: ${medicine.price}</li>
        <li>Осталось: ${medicine.quantity}</li>
        <li>Из группы:
            <form method="post" action="/catalog/class">
                <input type="hidden" name="id" value="${classification.id_class}"/>
                <input type="submit"class="btn btn-primary" value="${classification.description}">
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
                    <input type="submit" class="btn btn-primary" value="Добавить в корзину"/>
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
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>

</body>
</html>
