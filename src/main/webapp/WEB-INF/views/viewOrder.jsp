<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container wrapper">

    <div class="container-fluid">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Szczegóły zamówienia</h1>
                </div>
            </div>
        </section>

        <div class="container">
            <h2>Dane klienta</h2>
                    <p>${order.customerName}</p>
                    <p><strong>E-mail: </strong>${order.cart.customer.customerEmail}</p>
                    <p><strong>Telefon: </strong>${order.cart.customer.customerPhone}</p>
                    <p><strong>Adres: </strong>${order.shippingAddress}</p>
                    <h2>Zamówione produkty</h2>
                    <table class="table table-hover">
                        <tr>
                            <th>Nazwa produktu</th>
                            <th>Sztuk</th>
                        </tr>
                        <c:forEach items="${orderItems}" var="item">
                        <tr>
                            <td>${item.product.productName}</td>
                            <td>${item.quantity}</td>
                        </tr>
                        </c:forEach>
                        </table>
                    <br>


                    <c:set var="back" scope="page" value="/product/productList" />
                    <c:if test = "${pageContext.request.userPrincipal.name == 'admin'}">
                        <c:set var="back" scope="page" value="/admin/productInventory" />
                    </c:if>

                <div ng-app="orderApp" ng-controller = "orderCtrl" ng-init="initOrderId('${order.customerOrderId}')">

                    <a href="<c:url value="/admin/order" />" class="btn btn-default">Powrót</a>
                    <a href="#" class="btn btn-info btn-large" ng-click="confirmPaid()">Opłacone</a>
                    <a href="#" class="btn btn-info btn-large" ng-click="confirmSent()">Wysłane</a>

                </div>
            </div>
        </div>

<script src="<c:url value="/resources/js/orderController.js"/> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>