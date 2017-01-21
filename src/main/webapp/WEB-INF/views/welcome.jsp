<!--
- Author: Karolina Chadaj
- Description: Strona startowa sklepu internetowego.
-->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide home-image" src="<c:url value="/resources/images/back1.jpg"/>" alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h2>You always want to win. That is why you play tennis, because you love the sport and
                        try to be the best you can at it.
                    </h2>
                    <p>Roger Federer</p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide home-image" src="<c:url value="/resources/images/back2.jpg"/>" alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <h2>Tennis takes care of everything. It requires agility and quickness to get to the ball,
                        core strength to get power into your shorts and stamina to last for an entire match.
                    </h2>
                    <p>Samantha Stosur</p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide home-image" src="<c:url value="/resources/images/back4.jpg"/>" alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                    <h2>If you can keep playing tennis when somebody is shooting a gun down the street,
                        that's concentration.
                        </h2>
                    <p>Serena Williams</p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div><!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <img class="img-circle" src="<c:url value="/resources/images/table_tennis_racket_rect.jpg"/>" alt="Generic placeholder image" width="300" height="300">
            <h2>Tenis stołowy</h2>
            <a class="btn btn-default" href="<c:url value="/product/productList/tableTennis" /> " role="button">Przejdź &raquo;</a>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="<c:url value="/resources/images/tennis-ball-net.jpg"/>" alt="Generic placeholder image" width="300" height="300">
            <h2>Tenis ziemny</h2>
            <a class="btn btn-default" href="<c:url value="/product/productList/tennis" /> " role="button">Przejdź &raquo;</a>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="<c:url value="/resources/images/serena.jpg"/>" alt="Generic placeholder image" width="300" height="300">
            <h2>Odzież i akcesoria</h2>
            <a class="btn btn-default" href="<c:url value="/product/productList/clothes" /> " role="button">Przejdź &raquo;</a>
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->

<%@include file="/WEB-INF/views/template/footer.jsp"%>


