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
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<div id="content">
    <table border="1">
        <c:forEach items="${customerList}" var="custom">
            <tr>
                <td><form method="post" action="/customer/info">
                    <input type="hidden" name="email" value="${custom.email}"/>
                    <input type="submit" class="linkButton" value="${custom.email}">
                </form></td>
                <td>
                    ${custom.role}
                </td>
                <td>
                        ${custom.password}
                </td>
                <td><form action="/customer/admin" method="get">
                    <input type="hidden" name="id" value="${custom.id_custom}"/>
                    <input type="submit" class="linkButton" value="Сделать администратором">
                </form></td>
                <td><form action="/customer/del" method="post">
                    <input type="hidden" name="id" value="${custom.id_custom}"/>
                    <input type="submit" class="linkButton" value="Удалить">
                </form></td>
            </tr>

        </c:forEach>
    </table>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
