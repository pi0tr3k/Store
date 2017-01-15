<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container wrapper">

    <div class="container-fluid">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h2>${product.productName}</h2>
                </div>
            </div>
        </section>

        <div class="container" ng-app = "cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.productId}.png"/> " alt="image"
                         style="width:100%"/>
                </div>
                <div class="col-md-5">
                    <p>${product.productDescription}</p>
                    <p><strong>Producent: </strong>${product.productManufacturer}</p>
                    <p><strong>Kategoria: </strong>${product.productCategory}</p>
                    <p><strong>Opis: </strong>${product.productDescription}</p>
                    <h4>${product.productPrice} PLN</h4>

                    <br>


                    <c:set var="back" scope="page" value="/product/productList/tableTennis" />
                    <c:if test = "${product.productCategory == 'Tenis ziemny'}">
                        <c:set var="back" scope="page" value="/product/productList/tennis" />
                    </c:if>
                    <c:if test = "${product.productCategory == 'Ubrania i akcesoria'}">
                        <c:set var="back" scope="page" value="/product/productList/clothes" />
                    </c:if>
                    <c:if test = "${pageContext.request.userPrincipal.name == 'admin'}">
                        <c:set var="back" scope="page" value="/admin/productInventory" />
                    </c:if>


                    <p ng-controller="cartCtrl">
                    <a href="<c:url value="${back}" />" class="btn btn-default">Powrót</a>

<c:if test = "${pageContext.request.userPrincipal.name != 'admin'}">
                    <a href="#" class="btn btn-info btn-large" ng-click="addToCart('${product.productId}')">
                        <span class="glyphicon glyphicon-shopping-cart"></span> Zamów</a>
                    <a href="<spring:url value="/customer/cart" />" class="btn btn-default">
                        <span class="glyphicon glyphicon-hand-right"></span> Koszyk</a>
</c:if>
                    </p>
                </div>
            </div>
        </div>

<script src="<c:url value="/resources/js/controller.js"/> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>