

<%@page import="bookstore.helper.helpers"%>
<%@page import="bookstore.entities.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bookstore.helper.ConnectionProvider"%>
<%@page import="bookstore.Dao.ProductDao"%>
<%@page import="bookstore.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error_page.jsp" %>


<%
    User user=(User)session.getAttribute("currentuser");
    if(user==null){
        response.sendRedirect("SignIn.jsp");
    
    }
    
%>

<!DOCTYPE html>
<html>
    <head>
        
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>My Profile</title>
        <!--        css-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/mystyles.css" rel="stylesheet" type="text/css" >
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>
        <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
        
         <!--        javascript-->
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js'></script>
        
        <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css'></script>
          <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js'></script>
         
         <!--        jquery-->
        
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
       <style>



.carousel-item {
  height: 100vh;
  min-height: 350px;
  background: no-repeat center center scroll;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}


    
        </style>
    </head>
    <body>
         <%@include file="navbar.jsp" %>
        
 <h1>Books for sale.</h1>
   
   
   
   
   
   
   
   
   
   
   <div class="">
<%
    ProductDao dao=new ProductDao(ConnectionProvider.getConnection());
    ArrayList<Product> products=dao.getAllProducts();
      %>

<div class="col-md-8" >
    <div class="row mt-4">
        <div class="col-md-12">
            <div class="card-columns">
                <% for(Product pro:products){  %>
                
                    <div class="card" style="width: 18rem;">
                      <img class="card-img-top" src="IMG/products/<%=pro.getProduct_image() %>" alt="Card image cap">
                      <div class="card-body">
                          <h5 class="card-title"><%=pro.getProduct_title() %><br>Rs. <%=pro.getProduct_price() %></h5>
                          <p class="card-text"><%=helpers.get10words(pro.getProduct_description()) %></p>
                             <h5 class="card-title">Quantity : <%=pro.getProduct_quantity() %></h5>
                      </div>
                      <div class="card-footer">
                          <div id="loader" class="loading text-center" style="display:none">
                                        <span class="fa fa-repeat fa-spin fa-3x" ></span>
                                    <h4>Please Wait</h4>
                                    </div>
                          <button href="#" class="btn   btn-outline-primary" >&#8377; <%=pro.getProduct_price() %></button>
                          <form action="" method="" id="addtocart<%=pro.getProduct_id()%>"><button id="submit" type="submit" class="btn btn-primary">Add to cart</button>
                              </form>
                          
                      </div>
                    </div>
                    <br>
                    <br><br>
                    <script>
                           $(document).ready(function(){
                console.log("loaded........");
                
                $('#addtocart<%=pro.getProduct_id()%>').on('submit',function(event){
                    event.preventDefault();
                    let form=new FormData(this);
                            $("#submit").hide();
                            $("#loader").show();
                   
                    
                    //send data to register servlet
                    $.ajax({
                        url:"addtocartservlet?productid=<%=pro.getProduct_id()%>",
                        type:'POST',
                        data:form,
                        success: function(data,textStatus ,jqXHR){
                            console.log(data);
                                $("#submit").show();
                                $("#loader").hide();
                                
                                if(data.trim()=="done"){
                                
                                swal("product added successfully .Go to the checkout page.")
                                .then((value) => {
                                  window.location="profile.jsp"
                                });
                            }else if(data.trim()=="exist"){
                                
                                swal("Product exist in cart go to checkout.")
                                .then((value) => {
                                  window.location="profile.jsp"
                                });}
                            else{
                                swal(data)
                                
                            }
                            
                            
                        },
                        error: function( data ,textStatus ,errorThrown ){
                                 $("#submit").show();
                                $("#loader").hide();
                            swal("Something went wrong..try again")
                                .then((value) => {
                                  window.location="profile.jsp"
                                });
                        },
                        processData:false,
                        contentType:false
                    })
                     
                })
                
                
               
                
                
                
                
                
              });
            
                    </script>
                    

                        <%
                    }
                %>
                
                
                
            </div>
        </div>
    </div>
</div>
</div>
        
        


        
        
     
        
    
    </body>
</html>
