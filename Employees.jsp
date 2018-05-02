<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>

<div class="jumbotron" align="center">
  <h1>Employees Table CS245</h1>
</div>
<br>
<br>

<div align="center"> 
<form action="DeleteEmployees">
    <input class="btn btn-primary btn-lg" type="submit" value="Delete Employee"/>   
</form>
<br>
<form action="AddEmployees">
    <input class="btn btn-primary btn-lg" type="submit" value="Add Employee"/>
</form>
<br>
<form action="SearchId">
    <input class="btn btn-primary btn-lg" type="submit" value="Search By ID"/>
</form>
<br>
<form action="ModifyEmployees">
    <input class="btn btn-primary btn-lg" type="submit" value="Modify Employee"/>
</form>
<br>
<form action="Search1">
    <input class="btn btn-primary btn-lg" type="submit" value="Search1"/>
</form>
<br>
<form action="Search2">
    <input class="btn btn-primary btn-lg" type="submit" value="Search2"/>
</form>
<br>
<form action="Search3">
    <input class="btn btn-primary btn-lg" type="submit" value="Search3"/>
</form>
</div>

<br>
<br>
<br>
<h2 align="center">Table</h2>
<table class="table table-striped table table-bordered">
	<tr><th>Employee Id</th><th>Last Name</th><th>Hire Date</th><th>Birth Date</th>
	<th>Sex</th><th>Job Status</th><th>Pay Type</th><th>Annual Salary</th><th>Years Service</th></tr>
<c:forEach items="${entries}" var="entry">
	<tr>
		<td>${entry.emp_id}</td>
		<td>${entry.last_name}</td>
		<td>${entry.hire_date}</td>
		<td>${entry.birth_date}</td>
		<td>${entry.sex}</td>
		<td>${entry.job_status}</td>
		<td>${entry.pay_type}</td>
		<td>${entry.annual_salary}</td>
		<td>${entry.years_service}</td>
		</tr>
		</c:forEach>	
</table>

</body>
</html>