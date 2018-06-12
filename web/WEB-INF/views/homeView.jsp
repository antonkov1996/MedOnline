<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MedOnline</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<%--<jsp:include page="_menu.jsp"></jsp:include>--%>
<div id="carouselExampleIndicators" class="carousel slide container"  data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="d-block w-100" src="../../images/tablets-3442768_1920.jpg" alt="Первый слайд">
            <div class="carousel-caption d-none d-md-block">
                <h3>Большой выбор препаратов</h3>
                <a href="/catalog"><button class="btn btn-primary">Каталог</button></a>
            </div>
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="../../images/92nZi_croper_ru.jpeg" alt="Второй слайд">
            <div class="carousel-caption d-none d-md-block">
                <h3>Каталог производителей продукции</h3>
                <a href="/provider/all"><button class="btn btn-primary">Производители</button></a>
            </div>
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="../../images/E5MM0_croper_ru.jpeg" alt="Третий слайд">
            <div class="carousel-caption d-none d-md-block">
                <h3>Информация о сайте</h3>
                <a href="/about"><button class="btn btn-primary">О нас</button></a>
            </div>
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<div class="container"> 
      <h1> MedOnline </h1>
      <p class="lead"> Это сайт аптеки где вы можете забронировать неоюходимые препараты используя поиск по каталогу, производителям и по наименованию. <br /><br>

</div>

<jsp:include page="_footer.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>

