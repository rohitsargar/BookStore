

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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/mystyles.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body>
        
        <%@include file="navbar.jsp" %>
        
        
        <main class="d-flex align-items-center primary-background " >
            <div class="container mt-3">
                <div class="row">
                    <div class="col-md-6 offset-md-3">
                        <div class="card">
                            <div class="card-header primary-background text-white text-center">
                                <span class="fa fa-user-plus fa-3x " ></span>
                                <br>
                                <p>Register here</p>
                                
                            </div>
                            
                            
                            
                            
                            
                            
                            
                            <div class="card-body">
                                <form id="reg-form" action="registerservlet" method="post">
                                    
                                  <div class="form-group">
                                    <label for="user_name">Full Name</label>
                                    <input name="user_name" required type="text" class="form-control" id="user_name" aria-describedby="emailHelp" placeholder="Name">
                                  </div>
                                  <div class="form-group">
                                    <label for="phone_num">Phone number</label>
                                    <input name="user_phonenum" required type="text" class="form-control" id="phone_num" aria-describedby="emailHelp" placeholder="Mobile Number">
                                  </div>  
                                   
                                  <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input  name="user_email" required type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                  </div>
                                    
                                  <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input name="user_password" required type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                  </div>
                                    
                                    <div class="card-header primary-background text-white text-center">
                                        <p>Address Details</p>
                                    </div>
                                    
                                  <div class="form-group">
                                    <label for="uaddresrno">Room no.</label>
                                    <input name="user_addrrno" required type="text" class="form-control" id="uaddresrno" aria-describedby="emailHelp" placeholder="Room number">
                                  </div>
                                    <div class="form-group">
                                    <label for="uaddresfno">floor no.</label>
                                    <input name="user_addrfno" required type="text" class="form-control" id="uaddresrfno" aria-describedby="emailHelp" placeholder="Floor number">
                                  </div><div class="form-group">
                                    <label for="uaddresbn">Appartment Name</label>
                                    <input name="user_addrbn" required type="text" class="form-control" id="uaddresbn" aria-describedby="emailHelp" placeholder="Apartment Name">
                                  </div><div class="form-group">
                                    <label for="uaddresar">Address Line 2</label>
                                    <input name="user_addrar" required type="text" class="form-control" id="uaddresar" aria-describedby="emailHelp" placeholder="full Address">
                                  </div><div class="form-group">
                                    <label for="uaddreslm">landmark</label>
                                    <input name="user_addrlm" required type="text" class="form-control" id="uaddreslm" aria-describedby="emailHelp" placeholder="Landmark">
                                  </div><div class="form-group">
                                    <label for="uaddresct">City</label>
                                    <select name="user_addrct" class="form-control" id="uaddresct">
                                        <option value="Khanda Colony">Khanda Colony</option>
                                        
                                    </select>
<!--                                    <input name="user_addrct" required type="text" class="form-control" id="uaddresct" aria-describedby="emailHelp" placeholder="City">-->
                                  </div><div class="form-group">
                                    <label for="uaddreszp">Zip Code</label>
                                    <select name="user_addrzp" class="form-control" id="uaddreszp" >
                                        <option value="410206">410206</option>
                                        
                                    </select>
<!--                                    <input name="user_addrzp" required type="number" class="form-control" id="uaddreszp" aria-describedby="emailHelp" placeholder="Zip Code">-->
                                  </div>
                                    
                                  
                                    
                                  <div class="form-group">
                                       <label for="udescription">Description</label>
                                      <textarea name="user_descp" id="udescription" class="form-control" cols="30" rows="5" placeholder="Enter Something Here"></textarea>
                                    
                                  </div>
                                    
                                    
                                    
                                  <div class="form-check">
                                    <input name="user_check"type="checkbox" class="form-check-input" id="exampleCheck1">
                                    <label class="form-check-label" for="exampleCheck1">Agree Terms And Conditions</label>
                                  </div>
                                    
                                  
                                    <br>
                                    <div id="loader" class="loading text-center" style="display:none">
                                        <span class="fa fa-repeat fa-spin fa-3x" ></span>
                                    <h4>Please Wait</h4>
                                    </div>
                                    <br>
                                  <button id="submit" type="submit" class="btn btn-primary">Submit</button>
                                  
                                  
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
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
            $(document).ready(function(){
                console.log("loaded........")
                
                $('#reg-form').on('submit',function(event){
                    event.preventDefault();
                    let form=new FormData(this);
                            $("#submit").hide();
                            $("#loader").show();
                   
                    
                    //send data to register servlet
                    $.ajax({
                        url:"registerservlet",
                        type:'POST',
                        data:form,
                        success: function(data,textStatus ,jqXHR){
                            console.log(data)
                                $("#submit").show();
                                $("#loader").hide();
                                
                                if(data.trim()=="done"){
                                
                                swal("registered successfully we are redirecting to login page.")
                                .then((value) => {
                                  window.location="SignIn.jsp"
                                });
                            }else{
                                swal(data)
                                
                            }
                            
                            
                        },
                        error: function( data ,textStatus ,errorThrown ){
                                 $("#submit").show();
                                $("#loader").hide();
                            swal("Something went wrong..try again")
                                .then((value) => {
                                  window.location="login_page.jsp"
                                });
                        },
                        processData:false,
                        contentType:false
                    })
                     
                })
              });
            
        </script>
            
        
          
    </body>
</html>
        
        
