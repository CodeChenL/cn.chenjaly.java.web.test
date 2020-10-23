<%--
  Created by IntelliJ IDEA.
  User: 25407
  Date: 2020/10/22
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="bootstrap.min.css">
  <title>图书管理系统</title>
</head>
<body>
<div class="panel panel-primary">
  <!-- Default panel contents -->
  <div class="panel-heading">图书管理页面</div>
  <div class="panel-body form-inline">
    <form action="AddBookServlet">
      <div class="form-group">
        <label>书名</label>
        <input type="text" class="form-control" name="name">
      </div>

      <div class="form-group">
        <label>作者</label>
        <input type="text" class="form-control" name="author">
      </div>

      <div class="form-group">
        <label>价格</label>
        <input type="text" class="form-control" name="price">
      </div>
      <input type = "submit"  class="btn btn-primary" value="添加">
    </form>

  </div>
</div>

<table class="table table-bordered table-hover talbe-striped">
  <thead class="thead-inverse">
  <tr>
    <th>Id</th>
    <th>书名</th>
    <th>作者</th>
    <th>价格</th>
    <th>操作</th>
  </tr>
  </thead>
  <tbody>
  <!-- jsp模板 这里的数据必须从Servlet服务器获取
          1、这里我们在Servlet中先去数据库中查询数据
          2、然后通过request对象将数据转发传递到jsp中
          3、在服务器端结合数据使用jstl、el表达式生成html文件
          4、服务器端将这个页面响应给浏览器
   -->
  <c:forEach items="${bookList }" var="book">
    <tr>
      <td scope="row">${book.id }</td>
      <td>${book.name }</td>
      <td>${book.author }</td>
      <td>${book.price }</td>
      <td>
        <a href="#" class="btn btn-primary">修改</a>
        <a href="#" class="btn btn-danger">删除</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>