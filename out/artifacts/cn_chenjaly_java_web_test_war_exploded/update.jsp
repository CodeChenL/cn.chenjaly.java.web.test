<%--
  Created by IntelliJ IDEA.
  User: 25407
  Date: 2020/11/16
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>获取修改数据的页面</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<form action="UpdateBookServlet" methor="post">
    <input type="hidden" class="form-control" name="id" value="${book.id }">
    <div class="form-group">
        <label>书名</label>
        <input type="text" class="form-control" name="name" value="${book.name }">
    </div>

    <div class="form-group">
        <label>作者</label>
        <input type="text" class="form-control" name="author" value="${book.author }">
    </div>

    <div class="form-group">
        <label>价格</label>
        <input type="text" class="form-control" name="price" value="${book.price }">
    </div>
    <input type="submit" class="btn btn-primary" value="修改">


</form>
</body>
</html>
