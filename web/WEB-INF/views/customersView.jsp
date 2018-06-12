<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 6/6/18
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Клиенты</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="container">
<br>
    <div class="list-group">
        <c:forEach items="${customerList}" var="custom">
        <div class="row">
            <div class="col">
                <form method="post" action="/customer/info">
                    <input type="hidden" name="email" value="${custom.email}"/>
                    <input type="submit" class="list-group-item list-group-item-action" value="${custom.email}">
                </form>
            </div>
            <div class="col-12 col-md-auto">
            <form action="/customer/admin" method="get">
                <input type="hidden" name="id" value="${custom.id_custom}"/>
                <input type="submit" class="list-group-item list-group-item-action list-group-item-success"
                       value="Сделать администратором">
            </form>
        </div>
        <div class="col col-lg-2">
            <form action="/customer/del" method="post">
                <input type="hidden" name="id" value="${custom.id_custom}"/>
                <input type="submit" class="list-group-item list-group-item-action list-group-item-danger"
                       value="Удалить">
            </form>
        </div>
    </div>
    </c:forEach>
</div><br>
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
