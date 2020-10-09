<%--Brogan Avery  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>new book</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
Address Book Name: <input type ="text" name = "bookName"><br />
Book was created on: <input type ="text" name = "month" placeholder="mm" size="4"> <input type ="text" name = "day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4">
This book is owned by: <input type = "text" name = "ownerName"><br />

Available Addresses:<br />

<select name="allAddressesToAdd" multiple size="6">
<c:forEach items="${requestScope.allAddresses}" var="currentAddress">
   <option value = "${currentAddress.id}">${currentAddress.name} | ${currentAddress.address}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create Book and Add Addresses">
</form>
<a href = "index.html">Go add new addresses instead.</a>
</body>
</html>