<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NTSS</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<jsp:include page="navbar.jsp"></jsp:include>
</head>
<body>
<div class="container">
  <h1>Event Proposal</h1>
  <div class="card">
   <div class="card-body">
    <form action = "event/add" method="post">

     <div class=" form-group row">
      <label for="name" class="col-sm-2 col-form-label">Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="event_name"
        placeholder="Enter name">
      </div>
     </div>

     <div class="form-group row">
      <label for="theme" class="col-sm-2 col-form-label">Theme</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="theme"
        placeholder="Enter Theme">
      </div>
     </div>
     
     <div class="form-group row">
      <label for="slogan" class="col-sm-2 col-form-label">Slogan</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="slogan"
        placeholder="Enter Slogan">
      </div>
     </div>
     
     <div class="form-group row">
      <label for="location" class="col-sm-2 col-form-label">Location</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="location"
        placeholder="Enter Location">
      </div>
     </div>
     
     <div class="form-group row">
      <label for="duration" class="col-sm-2 col-form-label">Duration</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="duration"
        placeholder="Enter Duration">
      </div>
     </div>

	<div class="form-group row">
     <button type="submit" class="btn btn-primary">Register</button>
     </div>
    </form>
   </div>
  </div>
 </div>
</body>
</html>