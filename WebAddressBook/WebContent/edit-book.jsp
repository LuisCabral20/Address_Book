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
<title>Edit An Existing Address Book</title>
</head>
<body>

 <h2> Edit this book </h2>
<form action = "editBookDetailsServlet" method="post">
<input type ="hidden" name = "id" value= "${bookToEdit.id}">
Address Book Name: <input type ="text" name = "bookName" value= "${bookToEdit.bookName}">
<br><br>
Book was created on: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">
<br><br>
This book is owned by: <input type = "text" name = "ownerName" value= "${bookToEdit.owner.ownerName}">
<br><br>
Select the addresses you would like to put in this book:<br />

<select name="allAddressesToAdd" multiple size="6">
<c:forEach items="${requestScope.allAddresses}" var="currentAddress">
   <option value = "${currentAddress.id}">${currentAddress.name} | ${currentAddress.address}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Finished">
</form>
<a href = "index.html">Go add new Addresses instead.</a>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
