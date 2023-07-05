
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error_page.jsp" %>
<%@page import="bookstore.entities.User"%>

<%
    User user=(User)session.getAttribute("currentadminuser");
    if(user==null){
        response.sendRedirect("SignIn.jsp");
    
    }
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add </title>
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
                                <p>ADD PRODUCT</p>
                                
                            </div>
                            
                            
                            
                            
                            
                            
                            
                            <div class="card-body">
                                <form id="reg-form" action="addproductservlet" method="post">
                                    
                                  <div class="form-group">
                                    <label for="product_title">Title</label>
                                    <input name="product_title" required type="text" class="form-control" id="product_title" aria-describedby="emailHelp" placeholder="Product Title">
                                  </div>
                                  <div class="form-group">
                                    <label for="product_price">price</label>
                                    <input name="product_price" required type="number" class="form-control" id="product_price" aria-describedby="emailHelp" placeholder="Product Price">
                                  </div>  
                                   
                                  <div class="form-group">
                                    <label for="product_image">select picture of product</label>
                                    <input  name="product_image" required type="file" class="form-control" id="product_image"  placeholder="Product Image">
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                  </div>
                                    
                                  <div class="form-group">
                                    <label for="product_discount">Discount</label>
                                    <input name="product_discount" required type="number" class="form-control" id="product_discount" placeholder="Product Discount">
                                  </div>
                                     
                                  <div class="form-group">
                                    <label for="product_quantity">Quantity</label>
                                    <input name="product_quantity" required type="text" class="form-control" id="product_quantity"  placeholder="Product Quantity">
                                  </div>
                                   
                                  
                                    
                                  <div class="form-group">
                                       <label for="product_description">Description</label>
                                      <textarea name="product_description" id="product_description" class="form-control" cols="30" rows="5" placeholder="Enter Product Description Here"></textarea>
                                    
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
                        url:"addproductservlet",
                        type:'POST',
                        data:form,
                        success: function(data,textStatus ,jqXHR){
                            console.log(data)
                                $("#submit").show();
                                $("#loader").hide();
                                
                                if(data.trim()=="done"){
                                
                                swal("Product added successfully.")
                                .then((value) => {
                                  window.location="Add_Products.jsp"
                                }
                                        );
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
