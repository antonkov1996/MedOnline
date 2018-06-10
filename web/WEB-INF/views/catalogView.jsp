<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/21/18
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Каталог</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<div id="content">
    <p style="color: red;">${errorString}</p>


    <c:choose>
        <c:when test="${requestScope['javax.servlet.forward.request_uri']=='/catalog'}">
            <c:if test="${customer.role=='ADMIN'}">
                <a href="/class/add">add class</a><br>
            </c:if>
            <form action="/search" method="post">
                <input type="text" name="search" value="">
                <input type="submit" value="Поиск">
            </form>
            <c:forEach items="${classificationList}" var="classification">
                <form method="post" action="/catalog/class">
                    <input type="hidden" name="id" value="${classification.id_class}"/>
                    <input type="submit" class="linkButton" value="${classification.description}">
                </form>
            </c:forEach>
        </c:when>
        <c:when test="${requestScope['javax.servlet.forward.request_uri']=='/medicine/all'}">
            <a href="/medicine/create">medicine add</a> <br>
            <table border="1">
            <c:forEach items="${medicineList}" var="medicine">
                <tr>
                    <td><form method="post" action="/medicine">
                        <input type="hidden" name="id" value="${medicine.id_medicine}"/>
                        <input type="submit" class="linkButton" value="${medicine.medicine_name}">
                    </form></td>
                    <td><a href="/medicine/edit?id=${medicine.id_medicine}">Изменить</a> </td>
                    <td><td><form action="/medicine/delete" method="post">
                    <input type="hidden" name="id" value="${medicine.id_medicine}"/>
                    <input type="submit" class="linkButton" value="Удалить">
                </form></td></td>
                </tr>

            </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <c:forEach items="${medicineList}" var="medicine">
                <form method="post" action="/medicine">
                    <input type="hidden" name="id" value="${medicine.id_medicine}"/>
                    <input type="submit" class="linkButton" value="${medicine.medicine_name}">
                </form>
            </c:forEach>

        </c:otherwise>
    </c:choose>

    <br>
</div>
<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
