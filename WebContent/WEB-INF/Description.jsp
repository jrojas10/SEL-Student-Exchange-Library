<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Description</title>
    <link rel="stylesheet" href="styles/desc-styles.css">
  </head>
  
  <body>
    
    <div class="page">
      
      <div class="top">
        <h1>SEL - Description of a Book</h1>
        <button>Edit</button>
      </div>
      
      <div class = "split">

        <div class="left">
          
          <div class="display">
            <img src="test-img/book.jpg">
            <div class="book-info">
              <strong><em><div class="title">Analysis of Algorithms</div></em></strong>
              <div class="auth-box"><div>by : </div><div class="author">Micheal Cohem</div></div>
            </div>
          </div>
          
        </div>

        <div class="right">

          <div class="details">Details</div>

          <table>
            
            <tr>
              <td class="tb-col">Title</td>
              <td>Algorithm Analysis</td>
            </tr>

            <tr>
              <td class="tb-col">Author</td>
              <td>Cohen, Micheal</td>
            </tr>
            
            <tr>
              <td class="tb-col">Subject</td>
              <td>Computer Science</td>
            </tr>
            
            <tr>
              <td class="tb-col">Class</td>
              <td>CS - 3112</td>
            </tr>
            
            <tr>
              <td class="tb-col">Condition</td>
              <td>Good</td>
            </tr>
            
            <tr>
              <td class="tb-col">ISBN #</td>
              <td>1-123-1234-123-12</td>
            </tr>

          </table>
          
        </div>
          
      </div> <!-- End of Split Screen -->

      <div class="bottom">
        
        <div style="margin: .5em">Posted by : </div>
        
        <a href="/WEB-INF/Profile.jsp" class="profile-link">
          <div class="profile">
            <img src="test-img/default.png" id = "prof-pic" alt="yourBook">
            <strong><div id="prof-username">Username</div></strong>          
          </div>
        </a>
        
      </div>
      
    </div>
    
    
  </body>
  
</html>