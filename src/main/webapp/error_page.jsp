<%-- 
    Document   : error_page
    Created on : 27 Nov 2020, 11:53:44
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorry something went wrong.</title>
        
        
        <!--        css-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/mystyles.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            .banner-background{
                clip-path: polygon(50% 0%, 100% 0, 100% 54%, 100% 100%, 83% 95%, 54% 100%, 36% 96%, 0 100%, 0 0);  
            }
        </style>
        
    </head>
    <body>
        
        <div class="container text-center"  >
            <img src="img/images.jpg" class="img-fluid">
            <h1>something went wrong..</h1>
            <%=exception %>
            <a href="index.jsp" class="btn primary-background btn text-white mt-3">Home</a>
        </div>
        
        
    </body>
</html>
