
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/24/18
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Поставщики</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<div id="content">
    <p style="color: red;">${errorString}</p>
    <c:choose>
        <c:when test="${requestScope['javax.servlet.forward.request_uri']=='/provider/all'&& customer.role=='ADMIN'}">
            <a href="/provider/add">add provider</a>
            <table border="1">
                <c:forEach items="${providerList}" var="customer">
                    <tr>
                        <td><form method="post" action="/provider">
                            <input type="hidden" name="id" value="${customer.id_provider}"/>
                            <input type="submit" class="linkButton" value="${customer.prov_name}">
                        </form></td>
                        <td><form action="/provider/edit" method="get">
                            <input type="hidden" name="id" value="${customer.id_provider}"/>
                            <input type="submit" class="linkButton" value="Изменить">
                        </form></td>
                        <td><form action="/provider/del" method="post">
                            <input type="hidden" name="id" value="${customer.id_provider}"/>
                            <input type="submit" class="linkButton" value="Удалить">
                        </form></td>
                    </tr>

                </c:forEach>
            </table>
        </c:when>
        <c:when test="${requestScope['javax.servlet.forward.request_uri']=='/provider/all'}">
            <c:forEach items="${providerList}" var="customer">
                <form method="post" action="/provider">
                    <input type="hidden" name="id" value="${customer.id_provider}"/>
                    <input type="submit" class="linkButton" value="${customer.prov_name}">
                </form>
            </c:forEach>
        </c:when>

        <c:otherwise>
            Производитель: ${provider.prov_name}<br>
            Производит:<br>
            <c:forEach items="${medicineList}" var="medicine">
                <form method="post" action="/medicine">
                    <input type="hidden" name="id" value="${medicine.id_medicine}"/>
                    <input type="submit" class="linkButton" value="${medicine.medicine_name}">
                </form>
            </c:forEach>
        </c:otherwise>
    </c:choose>



    <%--<c:forEach items="providerList" var="provider">--%>
        <%--${provider.id_provider}--%>

    <%--</c:forEach>--%>




</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
