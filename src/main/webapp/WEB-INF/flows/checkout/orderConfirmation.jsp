<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<jsp:useBean id="now" class="java.util.Date" />
<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Zamówienie</h1>
            <p class="lead">Potwierdzenie zamówienia</p>
        </div>

        <div class="container">
            <div class="row">

        <form:form commandName="order" class="form-horizontal">

            <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">

        <div class="text-center">
            <h1>Rachunek</h1>
        </div>

                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <address>
                            <strong>Adres dostawy</strong><br>
                                ${order.cart.customer.shippingAddress.streetName} ${order.cart.customer.shippingAddress.apartmentNumber}
                            <br>
                                ${order.cart.customer.shippingAddress.zipCode} ${order.cart.customer.shippingAddress.city}
                            <br>
                                ${order.cart.customer.shippingAddress.country}
                            <br>
                        </address>
                        </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                    <p>Data dostawy: <fmt:formatDate type="date" value="${now}" /></p>    
                    </div>
                    </div>

                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <address>
                            <strong>Adres rozliczeniowy</strong><br>
                                ${order.cart.customer.billingAddress.streetName} ${order.cart.customer.billingAddress.apartmentNumber}
                            <br>
                                ${order.cart.customer.billingAddress.zipCode} ${order.cart.customer.billingAddress.city}
                            <br>
                                ${order.cart.customer.billingAddress.country}
                            <br>
                        </address>
                    </div>
                    </div>
                <div class="row">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Produkt</th>
                        <th>#</th>
                        <th class="text-center">Cena</th>
                        <th class="text-center">Suma</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="cartItem" items="${order.cart.cartItems}" >
                        <tr>
                            <td class="col-md-9"><em>${cartItem.product.productName}</em></td>
                            <td class="col-md-1" style="text-align: center">${cartItem.quantity}</td>
                            <td class="col-md-1">${cartItem.product.productPrice}</td>
                            <td class="col-md-1">${cartItem.totalPrice}</td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td></td>
                        <td></td>
                        <td class="text-right">
                            <h4><strong>Suma:</strong></h4>
                        </td>
                        <td class="text-center text-danger">
                            <h4><strong>${order.cart.grandTotal} PLN</strong></h4>
                        </td>
                    </tr>
                    </tbody>
                </table>
                </div>

        <input type="hidden" name="flowExecutionKey" />

        <br><br>
        <button class="btn btn-default" name="_eventId_backToCollectShippingDetail">Powrót</button>
        <input type="submit" value="Potwierdź zamówienie" class="btn btn-default" name="_eventId_orderConfirmed" />
        <button class="btn btn-default" name="_eventId_cancel">Anuluj</button>
            </div>
        </form:form>
                </div>
        </div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>