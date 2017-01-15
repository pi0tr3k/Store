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
                    <h1>Rejestracja</h1>
                </div>
            </div>
        </section>

        <div class="collectInfoForm">

        <form:form action="${pageContext.request.contextPath}/register" method="post"
                   commandName="customer">

        <h3>Podstawowe informacje</h3>

        <div class="form-group">
            <label for="name">Imię i nazwisko </label><form:errors path="customerName" cssStyle="color: red" />
            <form:input path="customerName" id="name" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="email">E-mail </label><span style="color: red">${emailMsg}</span>
            <form:errors path="customerEmail" cssStyle="color: red" />
            <form:input path="customerEmail" id="email" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="phone">Telefon</label>
            <form:input path="customerPhone" id="phone" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="username">Login </label><span style="color: red">${usernameMsg}</span>
            <form:errors path="username" cssStyle="color: red" />
            <form:input path="username" id="username" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="password">Hasło </label><form:errors path="password" cssStyle="color: red" />
            <form:password path="password" id="password" class="form-Control" />
        </div>

        <h3>Adres</h3>

        <div class="form-group">
            <label for="shippingStreet">Ulica i numer domu</label>
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



        <br><br>
        <input type="submit" class="btn btn-info">
        <a href="<c:url value="/" />" class="btn btn-default">Anuluj</a>

        </form:form>
        </div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>