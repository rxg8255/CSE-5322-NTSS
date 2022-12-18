<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<jsp:include page="navbar.jsp"></jsp:include>

<style>
h1{
	color: Green
}

</style>
</head>
<body>
	
	 <div class="container">
  <h1>Create an Account</h1>
  <div class="card">
   <div class="card-body">
    <form action = "signup" method="post">

     <div class=" form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">Email Address</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="email"
        placeholder="Enter Email">
      </div>
     </div>

     <div class="form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">Password</label>
      <div class="col-sm-7">
       <input type="password" class="form-control" name="password"
        placeholder="Enter Password">
      </div>
     </div>

	 <div class="form-group row">
	 <label  class="col-sm-2 col-form-label">User Type</label>
	  <div class="col-sm-7">
		     <select class="form-select" aria-label="Default select example" name="userType">			  
			  <option value="Speaker">Speaker</option>
			  <option value="Observer">Observer</option>
			  <option value="Exhibitor">Exhibitor</option>
			  <option value="Organizer">Organizer</option>
			 </select>
	    </div>
	    
	    <% 
     	String message = (String) request.getAttribute("signUpSuccess");
     			
     if(message != null){%>
      <h1 for="userLogin" class="col-sm-6 col-form-label"><%= message %></h1>
      <%
     }
	%>
	</div>


	<div class="form-group row">
     <button type="submit" class="btn btn-primary">SignUp</button>
     </div>
    </form>
   </div>
  </div>
 </div>

</body>
</html>