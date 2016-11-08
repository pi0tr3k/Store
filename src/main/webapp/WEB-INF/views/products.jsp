<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container wrapper">

   <div class="container">
        <div class="page-header">
            <h1>Produkty</h1>
            <p class="lead">Zapoznaj się z naszym asortymentem!</p>

        </div>

       <table class="table table-striped table-hover">
           <tr class="success">
               <th>Zdjęcie</th>
               <th>Nazwa produktu</th>
               <th>Kategoria</th>
               <th>Producent</th>
               <th>Sztuk w magazynie</th>
               <th>Cena</th>
               <th></th>
           </tr>

           <c:forEach items="${products}" var="product">

           <tr>
               <td><img src="<c:url value="/resources/images/${product.productId}.png"/> " alt="image"
                        style="width:100%"/></td>
               <td>${product.productName}</td>
               <td>${product.productCategory}</td>
               <td>${product.productManufacturer}</td>
               <td>${product.unitsInStock}</td>
               <td>${product.productPrice} PLN</td>
               <td><a href="<spring:url value="/productList/viewProduct/${product.productId}" />">
                   <span class="glyphicon glyphicon-info-sign"></span> </a> </td>
           </tr>

           </c:forEach>

       </table>

       <%@include file="/WEB-INF/views/template/footer.jsp"%>