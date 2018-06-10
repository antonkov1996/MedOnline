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
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<div id="content">
    <p style="color: red;">${errorString}</p>
    <h3>Информация о пользователе</h3>

    Почта: <b>${customer.email}</b><br>
    Фамилия: <b>${customer.last_name}</b><br>
    Имя: <b>${customer.first_name}</b><br>


    <br/>
    Роль: ${customer.role } <br/>

</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
