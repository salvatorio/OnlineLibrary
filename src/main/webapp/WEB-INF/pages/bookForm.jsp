<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Book Information</title>
  <!-- Bootstrap CSS -->
  <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
  <style type="text/css">
    .myrow-container{
      margin: 20px;
    }
  </style>
</head>
<body class=".container-fluid">
  <div class="container myrow-container">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">
          Book Details
        </h3>
      </div>

      <div class="panel-body">

        <form:form cssClass="form-horizontal" method="post" modelAttribute="book"
                   action="${context}/saveBook?${_csrf.parameterName}=${_csrf.token}"
                   enctype="multipart/form-data" >

        <form:errors path="*" />
          <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="name">Name</form:label> </div>
            <div class="col-xs-6">
              <form:hidden path="id" value="${bookObject.id}"/>
              <form:input cssClass="form-control" path="name" id="name" value="${bookObject.name}"/>
            </div>
          </div>

          <div class="form-group">
            <div class="control-label col-xs-3"><form:label path="code">Code</form:label></div>
            <div class="col-xs-6">
              <form:input cssClass="form-control" path="code" value="${bookObject.code}" maxlength="15"/>
            </div>
          </div>

          <div class="form-group">
            <div class="control-label col-xs-3"><form:label path="authors">Author(s)</form:label></div>
            <div class="col-xs-6">
              <form:input cssClass="form-control"  path="authors" id="authors" value="${bookObject.authors}" />
            </div>
          </div>

          <div class="form-group">
            <div class="control-label col-xs-3"><form:label path="isbn">ISBN</form:label></div>
            <div class="col-xs-6">
              <form:input cssClass="form-control" path="isbn" value="${bookObject.isbn}" />
            </div>
          </div>

          <div class="form-group">
            <div class="control-label col-xs-3"><form:label path="publisher">Publisher</form:label></div>
            <div class="col-xs-6">
              <form:input cssClass="form-control" path="publisher" value="${bookObject.publisher}" />
            </div>
          </div>

          <div class="form-group">
            <div class="control-label col-xs-3"><form:label path="publishedOn">Published On</form:label></div>
            <div class="col-xs-6">
              <form:input cssClass="form-control" path="publishedOn" placeholder="YYYY-MM-DD" value="${bookObject.publishedOn}" />
            </div>
          </div>

          <div class="form-group">
            <div class="control-label col-xs-3"><label>File</label></div>
            <div class="col-xs-6">
              <input cssClass="form-control" path="bookData" name="bookData" type="file"/>
            </div>
          </div>

          <div class="form-group">
            <div class="row">
              <div class="col-xs-4"></div>
              <div class="col-xs-4">
                <input type="submit" class="btn btn-default" value="Save" onclick="return submitBookForm();"/>
              </div>
              <div class="col-xs-4"></div>
            </div>
          </div>

        </form:form>
      </div>
    </div>

  </div>
<script src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/validationBook.js"/>"></script>

</body>
</html>
