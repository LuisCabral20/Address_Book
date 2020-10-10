<!--Brogan Avery  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit An Existing Address Book</title>
</head>
<body>
<form action = "editBookDetailsServlet" method="post">
<input type ="hidden" name = "id" value= "${bookToEdit.id}">
Address Book Name: <input type ="text" name = "bookName" value= "${bookToEdit.bookName}"><br />
Book was created on: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">
This book is owned by: <input type = "text" name = "ownerName" value= "${bookToEdit.owner.ownerName}"><br />

Available Addresses you can add to your book:<br />

<select name="allAddressesToAdd" multiple size="6">
<c:forEach items="${requestScope.allAddresses}" var="currentAddress">
   <option value = "${currentAddress.id}">${currentAddress.name} | ${currentAddress.address}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Edit Book and Add Addresses">
</form>
<a href = "index.html">Go add new Addresses instead.</a>
</body>
</html>
