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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>

</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="container">


    <form method="POST" action="${pageContext.request.contextPath}/login">
        <input type="hidden" name="redirectId" value="${param.redirectId}" />
        <div class="form-group">
            <label for="email">Ваша почта</label>
            <input type="text" class="form-control" id="email" name="email"
                   aria-describedby="почта"
                   placeholder="почта">
            <small id="почта" class="form-text text-muted">Введете почту.</small>
        </div>
        <div class="form-group">
            <label for="password">Пароль</label>
            <input type="text" class="form-control" name="password" id="password" aria-describedby="Пароль"
                   placeholder="Пароль">
            <small id="Пароль" class="form-text text-muted">Введете пароль.</small>
        </div>

        <button type="submit" class="btn btn-primary">Войти</button>
        <a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-primary">Отмена</button></a>
    </form>


</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

</body>
</html>
