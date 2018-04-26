<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Made with Brackets</title>
      <link rel="stylesheet" href="style.css">
    </head>

    <body>

      <h1>Post your book on SEL</h1>

      <form action="AddBook" method="get">
        
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
        
        <div class = "item">
          <div class="rad_btns">
            <label>Condition</label>

            <div class = rad> <input type="radio" name="condition">New</div>
            <div class = rad> <input type="radio" name="condition">Good</div>
            <div class = rad> <input type="radio" name="condition">Mid</div>
            <div class = rad> <input type="radio" name="condition">Poor</div>

          </div>
        </div>
        
        <div class = "item">
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