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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="container">
    <p style="color: red;">${errorString}</p>

    <form method="POST" action="${pageContext.request.contextPath}/medicine/create">
        <div class="form-group">
            <label for="med">Наименование препарата</label>
            <input type="text" class="form-control" id="med" name="medicine_name"
                   aria-describedby="Наименование препарата"
                   placeholder="Наименование препарата">
            <small id="Наименование препарата" class="form-text text-muted">Введете название препарата.</small>
        </div>
        <div class="form-group">
            <label for="id_provider">Производитель</label>
            <input type="text" class="form-control" name="id_provider" id="id_provider" aria-describedby="Производитель"
                   placeholder="Производитель">
            <small id="Производитель" class="form-text text-muted">Введете производителя.</small>
        </div>
        <div class="form-group">
            <label for="price">Цена</label>
            <input type="text" class="form-control" name="price" id="price" aria-describedby="Цена"
                   placeholder="Цена">
            <small id="Цена" class="form-text text-muted">Введете цену.</small>
        </div>
        <div class="form-group">
            <label for="quantity">Количество</label>
            <input type="text" class="form-control" name="quantity" id="quantity" aria-describedby="Количество"
                   placeholder="Количество">
            <small class="form-text text-muted">Введете количество.</small>
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Имя класса</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="id_class" aria-describedby="Имя класса"
                   placeholder="Имя класса">
            <small id="Имя класса" class="form-text text-muted">Введете класификацию.</small>
        </div>
        <button type="submit" class="btn btn-primary">Добавить</button>
        <a href="/medicine/all"><button type="button" class="btn btn-primary">Отмена</button></a>
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
