<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
    <link rel="stylesheet" href="post-styles.css">
</head>
  
  <body>
    
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