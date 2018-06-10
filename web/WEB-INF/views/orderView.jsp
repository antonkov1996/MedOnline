<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/24/18
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Заказы</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<div id="content">
    <p style="color: red;">${errorString}</p>
    <c:choose>
        <c:when test="${requestScope['javax.servlet.forward.request_uri']=='/yourorders'}">
            <p>Пользователь: ${customer.first_name} ${customer.last_name} </p><br>
            <c:choose>
                <c:when test="${medicineWrapperList.size()==0}">
                    <h2>Ваша корзина пуста</h2></p>
                </c:when>
                <c:otherwise>
                    <h2>Ваша корзина</h2><br>
                    <c:forEach items="${medicineWrapperList}" var="medicineW">
                        ${medicineW.medicine_name} количество: ${medicineW.quantity}  <a href="medicine/del?id=${medicineW.id_medicine}">удалить</a> <br>
                    </c:forEach>
                    <form method="post" action="/order/add">
                        <c:set var="medicineWrapperList" value="${medicineWrapperList}" scope="session"/>
                            <%--<input type="hidden" name="orderWrapperList" value="${orderWrapperList}"/>--%>
                        <input type="submit" value="Составить заказ">
                    </form>
                </c:otherwise>
            </c:choose>
            <h2>Ваши заказы</h2><br>
            <c:forEach items="${orderWrapperList}" var="orderWrap">
                <p><b>Заказ номер: ${orderWrap.id_order}</b></p>
                Дата заказа: ${orderWrap.order_date}<br><br>
                <c:forEach items="${orderWrap.ordered_medicineList}" var="order_medicine">
                    Наименование: ${order_medicine.medicine.medicine_name} Количество: ${order_medicine.quantity}<br>
                </c:forEach>
                <p>Всего: ${orderWrap.total}руб.</p><br>
                <form action="/order/print" method="post">
                    <c:set var="orderWrap" value="${orderWrap}" scope="session"/>
                    <input type="submit" class="linkButton" value="Получить отчет">
                </form>
            </c:forEach>

        </c:when>
        <c:otherwise>
            Simple orders <br>
            <table border="1">
            <c:forEach items="${orderList}" var="orders">
                <tr>
                    <td>id заказа ${orders.id_order}</td>
                    <td><form action="/order/del" method="post">
                        <input type="hidden" name="id" value="${orders.id_order}"/>
                        <input type="submit" class="linkButton" value="Удалить">
                    </form></td>
                </tr>


            </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
    <br>
    <br>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
