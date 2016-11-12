<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Klient</h1>
            <p class="lead">Szczegóły klienta</p>
        </div>

        <form:form commandName="order" class="form-horizontal">

        <h3>Podstawowe informacje</h3>

        <div class="form-group">
            <label for="name">Imię i nazwisko</label>
            <form:input path="cart.customer.customerName" id="name" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="email">E-mail</label>
            <form:input path="cart.customer.customerEmail" id="email" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="phone">Telefon</label>
            <form:input path="cart.customer.customerPhone" id="phone" class="form-Control" />
        </div>

        <h3>Adres rozliczeniowy</h3>

        <div class="form-group">
            <label for="billingStreet">Ulica</label>
            <form:input path="cart.customer.billingAddress.streetName" id="billingStreet" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingApartmentNumber">Numer mieszkania</label>
            <form:input path="cart.customer.billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingCity">Miasto</label>
            <form:input path="cart.customer.billingAddress.city" id="billingCity" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingZipCode">Kod pocztowy</label>
            <form:input path="cart.customer.billingAddress.zipCode" id="billingZipCode" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingCountry">Państwo</label>
            <form:input path="cart.customer.billingAddress.country" id="billingCountry" class="form-Control" />
        </div>

        <input type="hidden" name="flowExecutionKey" />

        <br><br>
        <input type="submit" value="Kontynuuj" class="btn btn-default" name="_eventId_customerInfoCollected" />
        <button class="btn btn-default" name="_eventId_cancel">Anuluj</button>
        </form:form>


<%@include file="/WEB-INF/views/template/footer.jsp"%>