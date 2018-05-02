<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Search By ID</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<div class="jumbotron" align="center">
  <h1>Search By ID</h1>

</div>
</br>
</br>
<div align="center">
<form action="Employees" method="post">
<input class="btn btn-primary btn-lg" type="submit" value="Employees"/>
</form>
</br>
</br>


<form class="form-inline" action="SearchId" method="post">
  <div class="form-group">
    <label for="employee_id">Employee ID</label>
    <input type="text" class="form-control" name="employee_id" >
  </div>
  <button type="submit" class="btn btn-primary">Search</button>
</form>

<!-- <form action="SearchId" method="post">
Employee ID: <input type="text" name="employee_id"/> 
<input type="submit" name="Search" value="Search" />
</form>
</div> -->


</body>
</html>