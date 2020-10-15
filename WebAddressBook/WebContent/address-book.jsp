<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- css file -->
<link href = "addressBookStyle.css" rel = "stylesheet" type = "text/css"/>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Address Book</title>
</head>


<body>
<div class="container">

	<h2>All addresses</h2>

	<form method = "post" action = "navigationServlet" >
		<table class="table table-striped table-dark table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col"></th>
	      			<th scope="col">Name</th>
	      			<th scope="col">Address</th>
	    			</tr>
			 </thead>
			 <tbody>
			 <c:forEach items="${requestScope.allAddresses}" var="currentAddress">
				<tr>
				   <td><input type="radio" name="id" value="${currentAddress.id}" ></td>
				   <td>${currentAddress.name}</td>
				   <td>${currentAddress.address}</td>
			    </tr>
			</c:forEach>
			</tbody>
		</table><br/>

		<input type = "submit" value = "edit" name="doThisToAddress" class="btn btn-info ">
		<input type = "submit" value = "delete" name="doThisToAddress" class="btn btn-info ">
		<br><br>

		<input type="submit" value = "add new entry" name = "doThisToAddress" class="btn btn-primary">
	</form>
	
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</body>
</html>
