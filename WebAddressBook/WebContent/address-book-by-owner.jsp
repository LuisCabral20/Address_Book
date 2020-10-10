<!--Brogan Avery  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Address Book</title>
</head>
<body>
<form method = "post" action = "booknavigationServlet">
<table>
<c:forEach items="${requestScope.allBooks}" var="currentBook">
<tr>
   <td><input type="radio" name="id" value="${currentBook.id}"></td>
   <td><h2>${currentBook.bookName}</h2></td></tr>
   <tr><td colspan="3">Book started on this date: ${currentBook.bookStartedDate}</td></tr>
   <tr><td colspan="3">This book belongs to: ${currentBook.owner.ownerName}</td></tr>
   <c:forEach var = "bookVal" items = "${currentBook.bookOfAddresses}">
            <tr><td></td><td colspan="3">
                ${bookVal.name}, ${bookVal.address}
                </td>
            </tr>
  </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToBook">
<input type = "submit" value = "delete" name="doThisToBook">
<!-- <input type="submit" value = "add" name = "doThisToBook"> -->
</form>
<br>
-OR-
<br><br>
<a href="addAddressesToBookServlet">Create a new address book</a>

</body>
</html>