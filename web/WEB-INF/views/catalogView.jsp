<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Каталог</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="container">
    <p style="color: red;">${errorString}</p>


    <c:choose>
        <c:when test="${requestScope['javax.servlet.forward.request_uri']=='/catalog'}">
            <div class="list-group">
                <c:forEach items="${classificationList}" var="classification">
                    <form method="post" action="/catalog/class">
                        <input type="hidden" name="id" value="${classification.id_class}"/>
                        <input type="submit" class="list-group-item list-group-item-action"
                               value="${classification.description}">
                    </form>
                </c:forEach>
            </div>
        </c:when>


        <c:when test="${requestScope['javax.servlet.forward.request_uri']=='/medicine/all'}">
            <div class="list-group">
                <c:forEach items="${medicineList}" var="medicine">
                    <div class="row">
                        <div class="col">
                            <form method="post" action="/medicine">
                                <input type="hidden" name="id" value="${medicine.id_medicine}"/>
                                <input type="submit" class="list-group-item list-group-item-action"
                                       value="${medicine.medicine_name}">
                            </form>
                        </div>
                        <div class="col-12 col-md-auto">
                            <a href="/medicine/edit?id=${medicine.id_medicine}"
                               class="list-group-item list-group-item-action list-group-item-success">Изменить</a>
                        </div>
                        <div class="col col-lg-2">
                            <form action="/medicine/delete" method="post">
                                <input type="hidden" name="id" value="${medicine.id_medicine}"/>
                                <input type="submit"
                                       class="list-group-item list-group-item-action list-group-item-danger"
                                       value="Удалить">
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:when>


        <c:otherwise>
            <div class="list-group">
                <c:forEach items="${medicineList}" var="medicine">
                    <form method="post" action="/medicine">
                        <input type="hidden" name="id" value="${medicine.id_medicine}"/>
                        <input type="submit" class="list-group-item list-group-item-action" value="${medicine.medicine_name}">
                    </form>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>

    <br>
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
