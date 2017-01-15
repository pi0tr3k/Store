<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container wrapper">

   <div class="container-fluid">
       <section>
           <div class="jumbotron">
               <div class="container">
                   <h1>Tenis ziemny</h1>
               </div>
           </div>
       </section>

       <table class="table table-striped table-hover">
           <tr class="info">
               <th></th>
               <th>Nazwa produktu</th>
               <th>Kategoria</th>
               <th>Producent</th>
               <th>Sztuk</th>
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
               <td><a href="<spring:url value="/product/viewProduct/${product.productId}" />">
                   <span class="glyphicon glyphicon-info-sign"></span> </a> </td>
           </tr>

           </c:forEach>

       </table>

       <%@include file="/WEB-INF/views/template/footer.jsp"%>