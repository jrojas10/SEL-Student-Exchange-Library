<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Made with Brackets</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  </head>
  
  <body>
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SEL</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="Post">Post</a></li>
      <li><a href="Profile">User Profile</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="SignUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
    
    <h1>Post your book on SEL</h1>
    
    <form action="" method="get">
      <label>Title</label>
      <input type="text">
      <label>Author's First Name</label>
      <input type="text">
      <label>Author's Last Name</label>
      <input type="text">
      <label>ISBN# </label>
      <input type="text">
      <label>Subject / Class </label>
      <input type="text">
        
        <div class="rad_btns">
           <label>Condition</label>
            
           <div class = rad> <input type="radio" name="condition">New </div>
           <div class = rad> <input type="radio" name="condition">Good </div>
           <div class = rad> <input type="radio" name="condition">Mid </div>
           <div class = rad> <input type="radio" name="condition">Poor </div>
           
        </div>
        
        <input type="submit" value="Submit">
        
    </form>
      
  </body>
  
</html>