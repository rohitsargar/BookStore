<%@page import="bookstore.entities.orders"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bookstore.helper.ConnectionProvider"%>
<%@page import="bookstore.Dao.OrdersDao"%>
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
        <title>My Cart</title>
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
         
         <!--        jquery-->
        
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
      
    </head>
    <body>
         <%@include file="navbar.jsp" %>

         <h2>Orders History</h2>

<table class="table">
  <tr>
      
    <th>product name</th>
    <th>product price</th>
    <th>QTY</th>
    <th>Total</th>
    <th>Delivery Address</th>
    <th>Orderd date</th>
    <th>product status</th>
  </tr>
  
  <% 

     OrdersDao order=new OrdersDao(ConnectionProvider.getConnection());
     ArrayList<orders> myorders=order.getAllUserOders(user.getUserId());
     for(orders ord:myorders){
     

  
  %>
  <tr>
      <td><%=ord.getProduct_name() %></td>
    <td><%=ord.getProduct_price() %></td>
    <td><%=ord.getProduct_quantity() %></td>
    <td><%=ord.getProduct_total() %></td>
    <td><%=ord.getUser_address() %></td>
    <td><%=ord.getTime() %></td>
    <td><%=ord.getProduct_status() %></td>
    
  </tr>
  <% } %>
  
</table>