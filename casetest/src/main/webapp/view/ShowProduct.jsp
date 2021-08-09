<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/08/2021
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!-- Place favicon.ico in the root directory -->
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.png">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">

</head>
<body>

<div class="container">
    <h2>Product List</h2>
    <p>All list in product</p>
    <a class="btn btn-info" style="text-align: left" href="/product?action=create">+Add new produt</a>
    <form method="post" action="/product?action=find" style="text-align: right">
        <input type="text" name="name_find"><button type="submit" class="btn btn-primary">find by name</button>
    </form>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>name</th>
            <th>price</th>
            <th>quantity</th>
            <th>color</th>
            <th>category</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productList}" var="product" varStatus="loop">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
                <td>${product.color}</td>
                <c:if test="${product.id_type == 1}">
                    <td>Phone</td>
                </c:if>
                <c:if test="${product.id_type == 2}">
                    <td>Sách</td>
                </c:if>
                <c:if test="${product.id_type == 3}">
                    <td>Laptop</td>
                </c:if>
                <c:if test="${product.id_type == 4}">
                    <td>khác</td>
                </c:if>
                <td>
                    <a href="/product?action=edit&index=${loop.index}" class="btn btn-warning">Edit</a>
                    <a href="/product?action=delete&index=${loop.index}"class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
