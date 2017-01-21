<%--
  - Author: Karolina Chadaj
  - Description: Widok logowania ...
  --%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container wrapper">

    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Adres dostawy</h1>
                </div>
            </div>
        </section>

        <div class="collectInfoForm">
        <form:form commandName="order" class="form-horizontal">

        <div class="form-group">
            <label for="name">Imię i nazwisko</label>
            <form:input path="customerName" id="name" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingStreet">Ulica</label>
            <form:input path="shippingAddress.streetName" id="shippingStreet" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingApartmentNumber">Numer mieszkania</label>
            <form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingCity">Miasto</label>
            <form:input path="shippingAddress.city" id="shippingCity" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingZipCode">Kod pocztowy</label>
            <form:input path="shippingAddress.zipCode" id="shippingZipCode" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingCountry">Państwo</label>
            <form:input path="shippingAddress.country" id="shippingCountry" class="form-Control" />
        </div>

        <input type="hidden" name="flowExecutionKey" />

        <br><br>
        <button class="btn btn-default" name="_eventId_cancel">Anuluj</button>
        <input type="submit" value="Kontynuuj" class="btn btn-info pull-right" name="_eventId_shippingDetailCollected" />
        </form:form>

            </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>