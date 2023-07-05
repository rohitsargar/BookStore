<%@page import="bookstore.entities.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error_page.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login Page</title>
        <!--        css-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" >
        <link href="css/mystyles.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        

   
    </head>
    <body>
        
        <%@include file="navbar.jsp" %>
        
        
        <main class="d-flex align-items-center primary-background " style="height: 100vh">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 offset-md-4">
                        <div class="card">
                            <div class="card-header primary-background text-white text-center">
                                <span class="fa fa-user-plus fa-3x " ></span>
                                <br>
                                <p>login here</p>
                                
                            </div>
                            
                            <% 

                                 Message msg=(Message)session.getAttribute("msg");
                                 if(msg!=null){
                                     %>
                                     
                                    <div class=" <%= msg.getType()%>  <%= msg.getCssclass()%> text-center" role="alert">
                                           <%=msg.getConatent()%>
                                    </div>
                                    
                                     
                                     
                                     
                                     
                                     
                                     
                                     <%
                                 
                                 }
                                  session.removeAttribute("msg");





                            %>
                            
                            
                            
                            
                            <div class="card-body">
                                <form action="signinservlet" method="post">
                                  <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input name="email" required type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                  </div>
                                  <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input name="password"  required type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                  </div>
                                  
                                  <button type="submit" class="btn btn-primary">Submit</button>
                                </form>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        
        
        
        
        
        
        
        
        
        
        
        
<!--        jquery-->
        
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
      
        
<!--        javascript-->
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
       
          
    </body>
</html>