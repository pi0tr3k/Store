<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container wrapper">

    <div class="container">
        <div class="page-header">
            <h1>Dodaj produkt</h1>
            <p class="lead">Wypełnij poniższy formularz aby dodać produkt</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct" method="post"
                   commandName="product" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Nazwa produktu</label> <form:errors path="productName" cssStyle="color:red"/>
            <form:input path="productName" id="name" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="category">Kategoria</label>
            <label class="checkbox-inline">
            <form:radiobutton path="productCategory" id="category" value="Tenis ziemny" />Tenis ziemny</label>
            <label class="checkbox-inline">
                <form:radiobutton path="productCategory" id="category" value="Tenis stołowy" />Tenis stołowy</label>
        </div>

        <div class="form-group">
            <label for="description">Opis</label>
            <form:textarea path="productDescription" id="description" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="price">Cena</label> <form:errors path="productPrice" cssStyle="color:red"/>
            <form:input path="productPrice" id="price" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="manufacturer">Producent</label>
            <form:input path="productManufacturer" id="manufacturer" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="unitsInStock">Sztuk w magazynie</label> <form:errors path="unitsInStock" cssStyle="color:red"/>
            <form:input path="unitsInStock" id="unitsInStock" class="form-Control" />
        </div>

        <div class="form-group">
            <label class="control-label" for="productImage">Dodaj zdjęcie</label>
            <form:input path="productImage" id="productImage" type="file" class="form:input-large" />
        </div>

        <br><br>

        <input type="submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Anuluj</a>

        </form:form>


<%@include file="/WEB-INF/views/template/footer.jsp"%>