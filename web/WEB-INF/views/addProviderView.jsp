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
    <title>Добавить производителя</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="container">
    <p style="color: red;">${errorString}</p>


    <form method="POST" action="${pageContext.request.contextPath}/provider/add">
        <div class="form-group">
            <label for="prov_name">Производитель</label>
            <input type="text" class="form-control" id="prov_name"  name="prov_name"
                   aria-describedby="Производитель"
                   placeholder="Производитель">
            <small id="Наименование препарата" class="form-text text-muted">Введете имя производитель.</small>
        </div>
        <div class="form-group">
            <label for="address">Адрес</label>
            <input type="text" class="form-control" name="address" id="address" aria-describedby="Адрес"
                   placeholder="Адрес">
            <small id="Адрес" class="form-text text-muted">Введете адрес производителя.</small>
        </div>
        <div class="form-group">
            <label for="city">Город</label>
            <input type="text" class="form-control" name="city" id="city" aria-describedby="Город"
                   placeholder="Город">
            <small id="Город" class="form-text text-muted">Введете город.</small>
        </div>
        <button type="submit" class="btn btn-primary">Добавить</button>
        <a href="/provider/all"><button type="button" class="btn btn-primary">Отмена</button></a>
    </form>
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
