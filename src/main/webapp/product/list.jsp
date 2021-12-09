<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: susu
  Date: 08/12/2021
  Time: 10:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Product List</h1>
<a href="/products?action=create">Create new product!</a> <br>
    <form action="">
        <input type="text" name="key" placeholder="Search here!">
        <button>Search</button>
    </form>
<table border="1" cellpadding="20px">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Description</th>
        <th>Category</th>
        <th>Actions</th>
    </tr>
  <c:forEach var="i" begin="0" end="${products.size()-1}">
      <tr>
          <td>${products.get(i).name}</td>
          <td>${products.get(i).price}</td>
          <td>${products.get(i).quantity}</td>
          <td>${products.get(i).color}</td>
          <td>${products.get(i).description}</td>
          <td>${categories.get(i).name}</td>
          <td>
              <a href="/products?action=edit&id=${products.get(i).id}">Edit</a>
              &ensp;
              <a onclick="return confirm('Are you sure to delete ${products.get(i).name}?')" href="/products?action=delete&id=${products.get(i).id}">Delete</a>
          </td>
      </tr>
  </c:forEach>
</table>
</center>
</body>
</html>
