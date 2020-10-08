<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Address Book</title>
</head>


<body>
<div class="container">
	
	<h2>Addresses possible to add to any book:</h2>
	
	<form method = "post" action = "navigationServlet" >
		<table class="table table-striped table-hover">
			<th> 
				<td>NAME</td>
				<td>ADDRESS</td>
				
			</th>
			<c:forEach items="${requestScope.allAddresses}" var="currentAddress">
				<tr>
				   <td><input type="radio" name="id" value="${currentAddress.id}" ></td>
				   <td>${currentitem.name}</td>
				   <td>${currentitem.address}</td>
			    </tr>
			</c:forEach>
		</table><br/>
		
		<input type = "submit" value = "edit" name="doThisToAddress" class="btn btn-warning">
		<input type = "submit" value = "delete" name="doThisToAddress" class="btn btn-danger">
		<input type="submit" value = "add" name = "doThisToAddress" class="btn btn-success">
	</form>
</div>
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</body>
</html>