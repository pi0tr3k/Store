<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container wrapper">

   <div class="container">
        <div class="page-header">
            <h1>All products</h1>
            <p class="lead">Checkout our products!</p>

        </div>

       <table class="table table-striped table-hover">
           <tr class="success">
               <th>Photo Thumb</th>
               <th>Product Name</th>
               <th>Category</th>
               <th>Manufacturer</th>
               <th>Units in stock</th>
               <th>Price</th>
               <th></th>
           </tr>

           <c:forEach items="${products}" var="product">

           <tr>
               <td><img src="#" alt="image" /></td>
               <td>${product.productName}</td>
               <td>${product.productCategory}</td>
               <td>${product.productManufacturer}</td>
               <td>${product.unitsInStock}</td>
               <td>${product.productPrice}</td>
               <td><a href="<spring:url value="/productList/viewProduct/${product.productId}" />">
                   <span class="glyphicon glyphicon-info-sign"></span> </a> </td>
           </tr>

           </c:forEach>

       </table>

       <%@include file="/WEB-INF/views/template/footer.jsp"%>