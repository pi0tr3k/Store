<%--
  - Author: Karolina Chadaj
  - Description: Widok koszyka zakupów.
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
                </div>
            </div>
        </section>

        <section class="container-fluid" ng-app="cartApp">
            <div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">

            <table class="table table-hover">
                <tr>
                    <th>Nazwa produktu</th>
                    <th>Cena</th>
                    <th>Sztuk</th>
                    <th>Suma</th>
                    <th></th>
                </tr>
                <tr ng-repeat = "item in cart.cartItems">
                    <td>{{item.product.productName}}</td>
                    <td>{{item.product.productPrice}}</td>
                    <td>{{item.quantity}}</td>
                    <td>{{item.totalPrice}}</td>
                    <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                        <span class="glyphicon glyphicon-remove"></span> Usuń</a></td>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Do zapłaty:</th>
                    <th>{{calGrandTotal()}}</th>
                    <th></th>
                </tr>
            </table>


                    <a href="<spring:url value="/" />" class="btn btn-default">Powrót do strony głównej</a>
                    <a class="btn btn-default" ng-click="clearCart()">
                        <span class="glyphicon glyphicon-remove"></span> Wyczyść koszyk</a>
                    <a href="<spring:url value="/order/${cartId}"/> " class="btn btn-primary pull-right">
                        <span class="glyphicon-shopping-cart glyphicon"></span> Złóż zamówienie</a>



            </div>
        </section>

    </div>



</div>

<script src="<c:url value="/resources/js/controller.js"/> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>
