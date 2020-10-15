<!--Brogan Avery  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <!-- Required meta tags -->
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <!-- css file -->
 <link href = "addressBookStyle.css" rel = "stylesheet" type = "text/css"/>
 <!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>new book</title>
<title>Address Book</title>
</head>
<body>
<form method = "post" action = "bookNavigationServlet">
<table>
<c:forEach items="${requestScope.allBooks}" var="currentBook">
<tr>
   <td><input type="radio" name="id" value="${currentBook.id}"></td>
   <td><h2>${currentBook.bookName}</h2></td></tr>
   <tr><td colspan="3">Book started on this date: ${currentBook.bookStartedDate}</td></tr>
   <tr><td colspan="3">This book belongs to: ${currentBook.owner.ownerName}</td></tr>

   <table class="table table-striped table-dark table-hover">
        <thead class="thead-dark">
             <tr>
                  <th scope="col"></th>
                  <th scope="col">Name</th>
                  <th scope="col">Address</th>
             </tr>
         </thead>
         <tbody>
   <c:forEach var = "bookVal" items = "${currentBook.bookOfAddresses}">
            <tr>
                 <td></td>
                 <td> ${bookVal.name} </td>
                 <td>${bookVal.address}</td>
            </tr>
  </c:forEach>
  </tbody>
</table>

</c:forEach>
</table>

<br><br>
<input type = "submit" value = "edit" name="doThisToBook" class="btn btn-info ">
<input type = "submit" value = "delete" name="doThisToBook" class="btn btn-info ">
<br><br>

<input type="submit" value = "createNewBook" name = "doThisToAddress" class="btn btn-primary">
</form>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
