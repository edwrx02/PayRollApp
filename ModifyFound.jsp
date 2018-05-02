<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Employee</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<div class="jumbotron" align="center">
  <h1>Modify Employee</h1>
</div>
<br>
<br>


<div id = "container" align="center">
<form action="Employees" method="post">
 <input class="btn btn-primary btn-lg" type="submit" value="Employees"/>
</form>
<br>
<form action = "ModifyFound" method = "post">
<table class="table table-striped table table-bordered">
<c:forEach items="${entries}" var="entry">
<tr><td>Employee Id: </td><td><input type = "text" name = "emp_id" value = "${entry.emp_id}"/></td></tr>
<tr><td>Last Name:</td><td><input type = "text" name = "last_name" value = "${entry.last_name}"/></td></tr>
<tr><td>Hire Date:</td><td><input type = "text" name = "hire_date" value = "${entry.hire_date}"/></td></tr>
<tr><td>Birth Date:<td><input type = "text" name = "birth_date" value = "${entry.birth_date}"/></td></tr>
<tr><td>Sex:</td><td><input type = "text" name = "sex" value = "${entry.sex}"/></td></tr>
<tr><td>Job Status:</td><td><input type = "text" name = "job_status" value = "${entry.job_status}"/></td></tr>
<tr><td>Pay Type:</td><td><input type = "text" name = "pay_type" value = "${entry.pay_type}"/></td></tr>
<tr><td>Annual Salary:</td><td><input type = "text" name = "annual_salary" value = "${entry.annual_salary}"/></td></tr>
<tr><td>Years of Service:</td><td><input type = "text" name = "years_service" value = "${entry.years_service}"/></td></tr>
		</c:forEach>
</table>

    <div class= align="center">
      <button type="submit" class="btn btn-primary btn-lg">Save</button>
    </div>
</form>
</div> 

		
</body>
</html>