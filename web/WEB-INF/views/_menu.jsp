<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="sidebar">
    <a href="/home">Главная</a><br>
    <a href="/catalog">Каталог товаров</a><br>
    <a href="/provider/all">Поставщики</a><br>
    <a href="/login">Войти</a><br>
    <a href="/logout">Выйти</a><br>
    <a href="/customerInfo">Информация пользователя</a><br>
    <a href="/yourorders">Выши заказы</a><br>
    <c:if test="${customer.role=='ADMIN'}">
        Пнель администратора<br>
        <a href="/order/all">Все заказы</a><br>
        <a href="/medicine/all">Все препараты</a><br>
        <a href="/provider/all">Поставщики</a><br>
        <a href="/customer/all">Клиенты</a><br>
    </c:if>
</div>