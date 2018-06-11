<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/24/18
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказы</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="container"> 
    <p style="color: red;">${errorString}</p>


    <c:choose>


        <c:when test="${requestScope['javax.servlet.forward.request_uri']=='/yourorders'}">
            <p><b>Пользователь: </b>${customer.first_name} ${customer.last_name} </p>
            <hr>
            <c:choose>
                <c:when test="${medicineWrapperList.size()==0}">
                    <h2>Ваша корзина пуста</h2></p><hr>
                </c:when>
                <c:otherwise>
                    <h2>Ваша корзина</h2><br>
                    <c:forEach items="${medicineWrapperList}" var="medicineW">

                        <div class="row">
                            <div class="col">
                                <form method="post" action="/medicine">
                                    <input type="hidden" name="id" value="${medicineW.id_medicine}"/>
                                    <input type="submit" class="list-group-item list-group-item-action"
                                           value="${medicineW.medicine_name}">
                                </form>
                            </div>
                            <div class="col-12 col-md-auto">
                                <p class="list-group-item list-group-item-action">Количество: ${medicineW.quantity}</p>
                            </div>
                            <div class="col col-lg-2">
                                <a  href="medicine/del?id=${medicineW.id_medicine}"><button class="list-group-item list-group-item-action list-group-item-danger">Удалить</button></a>
                            </div>
                        </div>
                    </c:forEach>
                    <hr>
                    <form method="post" action="/order/add">
                        <c:set var="medicineWrapperList" value="${medicineWrapperList}" scope="session"/>
                            <%--<input type="hidden" name="orderWrapperList" value="${orderWrapperList}"/>--%>
                        <input type="submit" value="Составить заказ">
                    </form>
                </c:otherwise>

            </c:choose>
            <h2>Ваши заказы</h2>
            <c:forEach items="${orderWrapperList}" var="orderWrap">
                <hr>
                <p><b>Заказ номер: ${orderWrap.id_order}</b></p>
                Дата заказа: ${orderWrap.order_date}<br><br>
                <c:forEach items="${orderWrap.ordered_medicineList}" var="order_medicine">
                    Наименование: ${order_medicine.medicine.medicine_name} Количество: ${order_medicine.quantity}<br>
                </c:forEach>
                <p>Всего: ${orderWrap.total}руб.</p><br>
                <form action="/order/print" method="post">
                    <c:set var="orderWrap" value="${orderWrap}" scope="session"/>
                    <input type="submit" class="btn btn-primary" value="Получить отчет">
                </form>
            </c:forEach>

        </c:when>


        <c:otherwise>
            <c:forEach items="${orderList}" var="orders">
                <hr>
                <p><b>Заказ номер: ${orders.id_order}</b></p>
                <p><b>Клиент номер: ${orders.id_customer}</b></p>
                <form action="/order/del" method="post">
                    <input type="hidden" name="id" value="${orders.id_order}"/>
                    <input type="submit" class="btn btn-primary"  value="Удалить">
                </form>


            </c:forEach>
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
