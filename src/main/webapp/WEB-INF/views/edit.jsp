<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: susu
  Date: 08/12/2021
  Time: 10:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <h3>Name</h3>
    <input type="text" name="name" placeholder="name">
    <h3>Price</h3>
    <input type="text" name="price" placeholder="price">
    <h3>Quantity</h3>
    <input type="text" name="quantity" placeholder="quantity">
    <h3>Color</h3>
    <input type="text" name="color" placeholder="color">
    <h3>Description</h3>
    <input type="text" name="description" placeholder="description">
    <h3>Category</h3>
    <select name="categoryName">
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <button>Edit</button>
</form>
</body>
</html>
