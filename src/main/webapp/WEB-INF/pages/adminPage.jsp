<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Books List</title>
  <!-- Bootstrap CSS -->
  <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
  <style type="text/css">
    .myrow-container {
      margin: 20px;
    }
  </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
  <div class="panel panel-default">
    <div class="panel-heading">
      <h3 class="panel-title">
          <div>
            <form class="form-inline" action="j_spring_security_logout" method="post">
              <div class="form-group" align="left">
                <p class="form-control-static">Books List | Admin page</p>
              </div>
              <a class="btn btn-default" href="${context}/adminPage"> Your login: <sec:authentication property="principal.username" /></a>
              <a class="btn btn-default" href="${context}/createBook">Add new book</a>
              <button type="submit" class="btn btn-default pull-right">Log out</button>
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
          </div>
       </h3>
    </div>
    <div class="panel-body">
      <c:if test="${empty bookList}">
        There are no books
      </c:if>
      <c:if test="${not empty bookList}">
        <table class="table table-hover  table-bordered">
          <tr>
            <th width="4%">№</th>
            <th width="12%">Name</th>
            <th width="12%">Code</th>
            <th width="12%">Authors</th>
            <th width="12%">ISBN</th>
            <th width="12%">Publisher</th>
            <th width="12%">Published On</th>
            <th width="12%">Download</th>
            <th width="12%">Edit</th>
            <th width="12%">Delete</th>
          </tr>
          <tbody>
            <c:forEach items="${bookList}" var="book" varStatus="loopCounter">
              <tr>
                <td><c:out value="${loopCounter.count}" /></td>
                <td><c:out value="${book.name}" /></td>
                <td><c:out value="${book.code}" /></td>
                <td><c:out value="${book.authors}" /></td>
                <td><c:out value="${book.isbn}" /></td>
                <td><c:out value="${book.publisher}" /></td>
                <td><c:out value="${book.publishedOn}" /></td>
                <td><a class="btn btn-success" target="_blank" href="${context}/downloadBook/${book.id}">Download</a></td>
                <td><a class="btn btn-primary" href="${context}/editBook/${book.id}">Edit</a></td>
                <td><a class="btn btn-danger" href="${context}/deleteBook/${book.id}"
                       onclick="return confirm('Are you sure you want to delete this book?');">Delete</a></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </c:if>
    </div>
  </div>
  <script src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
  <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</div>
</body>
</html>

