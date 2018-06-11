<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/22/18
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о пользователе</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<div class="container">
    <p style="color: red;">${errorString}</p>

    <c:choose>
        <c:when test="${requestScope['javax.servlet.forward.request_uri']=='/customer/info'}">
            <h3>Информация о пользователе</h3>
            id: <b>${customer.id_custom}</b><br>
            Почта: <b>${customer.email}</b><br>
            Фамилия: <b>${customer.last_name}</b><br>
            Имя: <b>${customer.first_name}</b><br>
            Пароль: <b>${customer.password}</b><br>

            <br/>
            Роль: ${customer.role } <br/>
        </c:when>
        <c:otherwise>
            <h3>Информация о пользователе</h3>

            Почта: <b>${customer.email}</b><br>
            Фамилия: <b>${customer.last_name}</b><br>
            Имя: <b>${customer.first_name}</b><br>


            <br/>
            Роль: ${customer.role } <br/>
        </c:otherwise>
    </c:choose>




</div>
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
