<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Adres dostawy</h1>
            <p class="lead">Wprowadź adres dostawy</p>
        </div>

        <form:form commandName="order" class="form-horizontal">

        <h3>Adres dostawy</h3>

        <div class="form-group">
            <label for="shippingStreet">Ulica</label>
            <form:input path="cart.customer.shippingAddress.streetName" id="shippingStreet" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingApartmentNumber">Numer mieszkania</label>
            <form:input path="cart.customer.shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingCity">Miasto</label>
            <form:input path="cart.customer.shippingAddress.city" id="shippingCity" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingZipCode">Kod pocztowy</label>
            <form:input path="cart.customer.shippingAddress.zipCode" id="shippingZipCode" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingCountry">Państwo</label>
            <form:input path="cart.customer.shippingAddress.country" id="shippingCountry" class="form-Control" />
        </div>

        <input type="hidden" name="flowExecutionKey" />

        <br><br>
        <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Powrót</button>
        <input type="submit" value="Kontynuuj" class="btn btn-default" name="_eventId_shippingDetailCollected" />
        <button class="btn btn-default" name="_eventId_cancel">Anuluj</button>
        </form:form>


<%@include file="/WEB-INF/views/template/footer.jsp"%>