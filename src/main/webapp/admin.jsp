
<%@page import="bookstore.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error_page.jsp" %>

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
        <title>Add products</title>
        <!--        css-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" >
        <link href="css/mystyles.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        

   
    </head>
    <body>
     
        <a href="Add_Products.jsp"><h1>Add Products</h1></a><br>
        <a href="adminlogoutservlet"><h1>LOGOUT</h1></a>
        <a href="admin_allorders.jsp"><h1>orders</h1></a>
        
        
    </body>
</html>
