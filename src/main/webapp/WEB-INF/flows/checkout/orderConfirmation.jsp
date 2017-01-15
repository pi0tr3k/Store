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
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Potwierdzenie zamówienia</h1>
                </div>
            </div>
        </section>

        <div class="container">
            <div class="row">

        <form:form commandName="order" class="form-horizontal">

            <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">

        <div class="text-center">
            <h1>Zamówienie</h1>
        </div>

                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <address>
                            <strong>Adres dostawy</strong><br>
                                ${order.customerName}
                            <br>
                                ${order.shippingAddress.streetName} ${order.shippingAddress.apartmentNumber}
                            <br>
                                ${order.shippingAddress.zipCode} ${order.shippingAddress.city}
                            <br>
                                ${order.shippingAddress.country}
                            <br>
                        </address>
                        </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                    <p>Data zamówienia: <fmt:formatDate type="date" value="${now}" /></p>
                    </div>
                    </div>


                <div class="row">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Nazwa produktu</th>
                        <th>Sztuk</th>
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
                            <h4><strong>Do zapłaty:</strong></h4>
                        </td>
                        <td class="text-center text-primary">
                            <h4><strong>${order.cart.grandTotal} PLN</strong></h4>
                        </td>
                    </tr>
                    </tbody>
                </table>
                </div>

        <input type="hidden" name="flowExecutionKey" />

        <br><br>
        <button class="btn btn-default" name="_eventId_backToCollectShippingDetail">Powrót</button>
                <button class="btn btn-default" name="_eventId_cancel">Anuluj</button>
                <input type="submit" value="Potwierdź zamówienie" class="btn btn-primary pull-right" name="_eventId_orderConfirmed" />

            </div>
        </form:form>
                </div>
        </div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>