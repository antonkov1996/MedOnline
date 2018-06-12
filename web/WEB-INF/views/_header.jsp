<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/Style.css"/>--%>
<%--<div id="header">--%>
<%--<h1 align="left">MedOnline.ml</h1>--%>
<%--</div>--%>


<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="/home">MedOnline</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/catalog">Каталог <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/provider/all">Производители <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Аккаунт
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/login">Вход</a>
                    <a class="dropdown-item" href="/logout">Выход</a>
                    <a class="dropdown-item" href="/register">Регистрация</a>
                    <a class="dropdown-item" href="/customerInfo">Информация о пользователе</a>
                    <a class="dropdown-item" href="/yourorders">Ваши заказы</a>
                </div>
            </li>
            <c:if test="${customer.role=='ADMIN'}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="adminDropdown" role="button" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Администратор
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/order/all">Все заказы</a>
                        <a class="dropdown-item" href="/medicine/all">Все препараты</a>
                        <a class="dropdown-item" href="/provider/all">Производителя</a>
                        <a class="dropdown-item" href="/customer/all">Клиенты</a>
                        <a class="dropdown-item" href="/class/add">Добавить классификацию</a>
                        <a class="dropdown-item" href="/medicine/create">Добавить препарат</a>
                        <a class="dropdown-item" href="/provider/add">Добавить производителя</a>
                    </div>
                <li class="nav-item active">

                    <a class="nav-link" href="../../images/Spravka.chm">Справка <span class="sr-only">(current)</span></a>
                </li>
                </li>
            </c:if>

        </ul>
        <form class="form-inline my-2 my-lg-0" action="/search" method="post">
            <input class="form-control mr-sm-2" type="text" placeholder="Поиск" name="search" aria-label="Поиск">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
        </form>
    </div>
</nav>