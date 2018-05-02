<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <html>
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Post Your Book on SEL!</title>
      <link rel="stylesheet" href="styles/post-styles.css">
      <link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
    </head>

    <body>

	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="Home">SEL</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="Home">Home</a></li>
	      <li class="active"><a href="Post">Post</a></li>
	      <li><a href="Profile">User Profile</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="SignUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	    </ul>
	  </div>
	</nav>

      <h1>Post your book on SEL</h1>

      <form action="AddBook" method="post">
        
        <div class = "item">
          <label>Title</label>
          <input type="text" name = "title" placeholder = "Ex. Analysis of Algothims">
        </div>
        
        <div class = "item">
          <label>Author's First Name</label>
          <input type="text" name = "authFirstName" placeholder = "Ex. Micheal">
        </div>
        
        <div class = "item">
          <label>Author's Last Name</label>
          <input type="text" name="authLastName" placeholder = "Ex. Cohem">
        </div>
        
        <div class = "item">
          <label>ISBN# </label>
          <input type="text" name="isbn" placeholder = "Ex. 123-1-1234-1234-1">
        </div>
        
        <div class = "item">
          <label>Subject </label>
          <input type="text" name="subject" placeholder = "Ex. Computer Science">
        </div>
        
        <div class = "item">
          <label>Class </label>
          <input type="text" name="ofClass" placeholder = "Ex. CS-3112">
        </div>
        
        <div class = "item state">
          <div class="rad_btns">
            <label>Condition</label>

            <div class = rad> <input type="radio" name="condition" value="New">New</div>
            <div class = rad> <input type="radio" name="condition" value="Good">Good</div>
            <div class = rad> <input type="radio" name="condition" value="Mid">Mid</div>
            <div class = rad> <input type="radio" name="condition" value="Poor">Poor</div>

          </div>
        </div>
        
        <div class = "item pri">
          <label>Price </label> 
          <div class="price" style="display: flex;">
            <label> $ </label>
            <input type="number" name="price" placeholder = "Ex. 22">
          </div>          
        </div>
        
        <div class = "cont">
          <div class = "item" id="btn">
            <input type="submit" value="Submit">
          </div>
        </div>
      </form>

    </body>

  </html>
