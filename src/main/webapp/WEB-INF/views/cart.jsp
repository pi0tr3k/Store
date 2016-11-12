<%--
  Created by IntelliJ IDEA.
  User: chada
  Date: 06.11.2016
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Koszyk</h1>
                    <p>Wszystkie wybrane produkty w Twoim koszyku</p>
                </div>
            </div>
        </section>

        <section class="container" ng-app="cartApp">
            <div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">
            <div>
                <a class="btn btn-danger pull-left" ng-click="clearCart()"><span class="glyphicon glyphicon-remove"></span>
                    Wyczyść koszyk</a>
                <a href="<spring:url value="/order/${cartId}"/> " class="btn btn-success pull-right">
                    <span class="glyphicon-shopping-cart glyphicon"></span>Złóż zamówienie
                </a>
            </div>

            <table class="table table-hover">
                <tr>
                    <th>Nazwa produktu</th>
                    <th>Cena jednostkowa</th>
                    <th>Ilość</th>
                    <th>Cena</th>
                    <th>Akcja</th>
                </tr>
                <tr ng-repeat = "item in cart.cartItems">
                    <td>{{item.product.productName}}</td>
                    <td>{{item.product.productPrice}}</td>
                    <td>{{item.quantity}}</td>
                    <td>{{item.totalPrice}}</td>
                    <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                        <span class="glyphicon glyphicon-remove"></span>usuń</a></td>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th>GrandTotal</th>
                    <th>{{calGrandTotal()}}</th>
                    <th></th>
                </tr>
            </table>

            <a href="<spring:url value="/productList" />" class="btn btn-default">Kontynuuj zakupy</a>
            </div>
        </section>

    </div>



</div>

<!--nie brakuje tu angulara?-->
<script src="<c:url value="/resources/js/controller.js"/> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>
