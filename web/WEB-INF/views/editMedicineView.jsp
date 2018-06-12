<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="container">
    <p style="color: red;">${errorString}</p>

<c:if test="${not empty medicine}">
    <form method="POST" action="${pageContext.request.contextPath}/medicine/edit">
        <input type="hidden" name="id" value="${medicine.id_medicine}" />
        <p>id препарата: ${medicine.id_medicine}</p>
        <div class="form-group">
            <label for="med">Наименование препарата</label>
            <input type="text" class="form-control" id="med" name="medicine_name"  value="${medicine.medicine_name}"
                   aria-describedby="Наименование препарата"
                   placeholder="Наименование препарата">
            <small id="Наименование препарата" class="form-text text-muted">Введете название препарата.</small>
        </div>
        <div class="form-group">
            <label for="id_provider">Производитель</label>
            <input type="text" class="form-control" name="id_provider" id="id_provider" aria-describedby="Производитель" value="${medicine.id_provider}"
                   placeholder="Производитель">
            <small id="Производитель" class="form-text text-muted">Введете производителя.</small>
        </div>
        <div class="form-group">
            <label for="price">Цена</label>
            <input type="text" class="form-control" name="price" id="price" aria-describedby="Цена" value="${medicine.price}"
                   placeholder="Цена">
            <small id="Цена" class="form-text text-muted">Введете цену.</small>
        </div>
        <div class="form-group">
            <label for="quantity">Количество</label>
            <input type="text" class="form-control" name="quantity" id="quantity" aria-describedby="Количество" value="${medicine.quantity}"
                   placeholder="Количество">
            <small class="form-text text-muted">Введете количество.</small>
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Имя класса</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="id_class" aria-describedby="Имя класса" alue="${medicine.id_class}"
                   placeholder="Имя класса">
            <small id="Имя класса" class="form-text text-muted">Введете класификацию.</small>
        </div>
        <button type="submit" class="btn btn-primary">Изменить</button>
        <a href="/medicine/all"><button type="button" class="btn btn-primary">Отмена</button></a>
    </form>

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
