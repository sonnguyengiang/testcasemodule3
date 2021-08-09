<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/08/2021
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!-- Place favicon.ico in the root directory -->
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.png">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">

</head>
<body>
<h1>Add New Product</h1><br>
<form action="/product?action=create" method="post">
    <h5>Name</h5><br>
    <input type="text" class="form-control" name="name"><br>
    <h5>Price</h5><br>
    <input type="text" class="form-control" name="price"><br>
    <h5>Quantity</h5><br>
    <input type="text" class="form-control" name="quantity"><br>
    <h5>Color</h5><br>
    <input type="text" class="form-control" name="color"><br>
    <div class="form-group">
        <label for="comment">Comment:</label>
        <textarea class="form-control" rows="4" id="comment" name="mota"></textarea>
    </div>
    <h5>Name</h5><br>
    <td>
        <select name="type" class="form-control">
            <option value="1">Phone</option>
            <option value="2">Sách</option>
            <option value="3">Laptop</option>
            <option value="4">Khác</option>
        </select>
    </td>
    <button class="btn btn-success" href="/product?action=create">Create</button><a class="btn btn-default" href="/product">Back</a><br>
</form>
</body>
</html>
