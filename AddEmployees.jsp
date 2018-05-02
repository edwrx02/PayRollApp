<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employees</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<div class="jumbotron" align="center">
  <h1>Add Employee</h1>

</div>
<br>
<div align="center">
<form action="Employees" method="post">
<input class="btn btn-primary btn-lg" type="submit" value="Employees"/>
</form>
</div>
<br>
<h3 align="center"> Add the information for the new Employee </h3>
<br>





<form class="form-horizontal" action="AddEmployees" method="post">
  <div class="form-group">
    <label for="last_name" class="col-sm-2 control-label">Last Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="last_name" placeholder="Last Name">
    </div>
  </div>
  <div class="form-group">
    <label for="hire_date" class="col-sm-2 control-label">Hire Date</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="hire_date" placeholder="YYYY-MM-DD">
    </div>
  </div>
    <div class="form-group">
    <label for="birth_date" class="col-sm-2 control-label">Birth Date</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="birth_date" placeholder="YYYY-MM-DD">
    </div>
  </div>
   <div class="form-group">
    <label for="sex" class="col-sm-2 control-label">Sex</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="sex" placeholder="Sex">
    </div>
  </div>
    <div class="form-group">
    <label for="job_status" class="col-sm-2 control-label">Job Status</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="job_status" placeholder="Job Status">
    </div>
  </div>
      <div class="form-group">
    <label for="pay_type" class="col-sm-2 control-label">Pay Type</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="pay_type" placeholder="Pay Type">
    </div>
  </div>
    <div class="form-group">
    <label for="annual_salary" class="col-sm-2 control-label">Annual Salary</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="annual_salary" placeholder="Annual Salary">
    </div>
  </div> 
     <div class="form-group">
   <label for="years_service" class="col-sm-2 control-label">Years of Service</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="years_service" placeholder="Years of Service">
    </div>
  </div>
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">ADD</button>
    </div>
  </div>
</form>


<!-- <form action="AddEmployees" method="post">
Last name: <input type="text" name="last_name"/> <br />
Hire Date: <input type="text" name="hire_date"/> <br />
Birth Date: <input type="text" name="birth_date"/> <br />
Sex: <input type="text" name="sex"/> <br />
Job Status <input type="text" name="job_status"/> <br />
Pay Type <input type="text" name="pay_type"/> <br />
Annual Salary <input type="text" name="annual_salary"/> <br />
Years Service <input type="text" name="years_service"/> <br />
<input type="submit" name="add" value="Add" />
</form> -->
</body>
</html>