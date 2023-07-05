<%@page import="bookstore.entities.User"%>
<%
    User user1=(User)session.getAttribute("currentuser");
    
    
%>
<nav class="navbar navbar-expand-lg navbar-dark primary-background">
    <a class="navbar-brand" href="mycart.jsp">Book Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      
<!--      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Categories
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>-->
      <li class="nav-item">
        <a class="nav-link " href="#">Contact Us</a>
      </li>
      
      <%  if(user1==null){
          
       %>   <li class="nav-item">
        <a class="nav-link " href="SignIn.jsp">SignIn</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="SignUp.jsp">SignUp</a>
      </li>
      
       
      
      <%
      
      }else{
          
      %>
      </ul>
      
      <ul class="navbar-nav mr-right">
          <li class="nav-item">
            <a class="nav-link " href="mycart.jsp">MyCart</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="myorders.jsp">My Orders</a>
          </li>
          
              
              <a type="button" class="nav-link " data-toggle="modal" data-target="#exampleModal"><span class="fa fa-user-circle-o"></span><%=user1.getName()%></a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="logoutservlet">LOGOUT</a>
          </li>
          
           
      
      </ul>

          
      
      <% 
      
      
      }
          %>
          
     
      
      
      
      
   
<!--    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>-->
  </div>
</nav>
