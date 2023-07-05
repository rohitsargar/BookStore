
<%@page import="bookstore.entities.Product"%>
<%@page import="bookstore.Dao.ProductDao"%>
<%@page import="bookstore.entities.CartProducts"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bookstore.Dao.CartDao"%>
<%@page import="bookstore.helper.ConnectionProvider"%>
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
        <title>My Cart</title>
        <!--        css-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/mystyles.css" rel="stylesheet" type="text/css" >
        <link href="css/cartdesign.css" rel="stylesheet" type="text/css" >
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

<!--	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>-->
                                            
                                            
                                            
 <div class="card">
    <div class="row">
        <div class="col-md-8 cart">
            <div class="title">
                <div class="row">
                    <div class="col">
                        <h4><b>Shopping Cart</b></h4>
                    </div>
<!--                    <div class="col align-self-center text-right text-muted">3 items</div>-->
                </div>
            </div>
            <div class="row" style="color: #2196f3;">
                <div class="row main align-items-center">
                    <div class="col-2"></div>
                    <div class="col">
<!--                        <div class="row text-muted">Shirt</div>-->
                        <div class="row">Name</div>
                    </div>
                    <div class="col">Qty</div>
                    <div class="col">&#x20B9;/pro</div>
                    <div class="col">  &#8721; &#x20B9;</div>
                        Delete
                </div>
                </div>
                                            <%
                                              
       int total_num_pro=0;
       CartDao dao=new CartDao(ConnectionProvider.getConnection());
       
       ArrayList<CartProducts> products=dao.getAllUserCartProducts(dao.getCartIdByUser(user));
       if(products.size()>0){
       
      %>
      
      <% ProductDao prodao=new ProductDao(ConnectionProvider.getConnection());
          for(CartProducts cartproduct:products){
             
           Product pro = prodao.getProductByid(cartproduct.getProduct_id()) ; 
           
              
          
           
          %>
          
          
          
         
            <div class="row">
                <div class="row main align-items-center">
                    <div class="col-2"><img class="img-fluid" src="IMG/products/<%=pro.getProduct_image() %>" alt="..."></div>
                    <div class="col">
<!--                        <div class="row text-muted">Shirt</div>-->
                        <div class="row"><%=pro.getProduct_title() %></div>
                    </div>
                    <div class="col"> 
                    <a href="decreasequantity?cartproductid=<%=cartproduct.getId() %>" class="border">-</a>
                        <a href="#" class="border">
                            <%=(cartproduct.getProduct_quantity()) %>
                        </a>
                    <a href="increasequantity?cartproductid=<%=cartproduct.getId() %>" class="border">+</a> </div>
                    <div class="col">&#x20B9; <%=(pro.getProduct_price()) %> </div>
                    <div class="col">&#x20B9; <%=(cartproduct.getProduct_quantity()*Integer.parseInt(pro.getProduct_price())) %></div>
                        <a class="close" href="DeleteProductFromCart?id=<%=cartproduct.getId() %>" >&#10005;</a></div>
                </div><%
                    
                       total_num_pro=total_num_pro+cartproduct.getProduct_quantity();
                    
                %>
            
            
            
            
          
          
          
          
          
          
          
          
          
          
                                            
                                            
                                            
<!--						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="IMG/products/<%=pro.getProduct_image() %>" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin"><%=pro.getProduct_title() %>  </h4>
										<p>Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Lorem ipsum dolor sit amet.</p>
									</div>
								</div>
							</td>
							<td data-th="Price">Rs.<%=(pro.getProduct_price()) %>  </td>
                                                        
                                                        decrese quantity  button
							
                                                        <td> <a href="decreasequantity?cartproductid=<%=cartproduct.getId() %>">-</a></td>
                                                        
                                                                <td data-th="Quantity">
								<input type="text" class="form-control text-center" value="<%=(cartproduct.getProduct_quantity()) %>" readonly>
                                                                </td>
                                                        increase quantity button    
                                                        <td> <a href="increasequantity?cartproductid=<%=cartproduct.getId() %>">+</a></td>
                                                        <td>   
                                                        <td data-th="Subtotal" class="text-center"><%=(cartproduct.getProduct_quantity()*Integer.parseInt(pro.getProduct_price())) %></td>
							<td class="actions" data-th="">
								<button class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>
                                                                <a href="DeleteProductFromCart?id=<%=cartproduct.getId() %>"><button class="btn btn-danger btn-sm" ><i class="fa fa-trash-o"></i></button></a>								
							</td>
						</tr>
					</tbody>-->
                                        
                                         <%
                                         } %>
<!--					<tfoot>
						
						<tr>
							<td><a href="profile.jsp" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
                                                        <td class="hidden-xs text-center"><strong><%=dao.gettotalprice(products) %></strong></td>
                                                        <td><a href="addorderservlet?cartid=<%=dao.getCartIdByUser(user)%>" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
</div>-->

<div class="back-to-shop"><a href="profile.jsp">&leftarrow; Back to shop</a></div>
        </div>
        <div class="col-md-4 summary">
            <div>
                <h5><b>Summary</b></h5>
            </div>
            <hr>
            
            <form>
                <p>Shipping</p> <select>
                    <option class="text-muted">Standard-Delivery- &#x20B9; 10.00</option>
                </select>
                <p>Payment Method</p> <select>
                    <option class="text-muted">COD</option>
                </select>
                
<!--                <p>GIVE CODE</p> <input id="code" placeholder="Enter your code">-->
            </form>
            <hr>
            <p>Address</p>
            <div class="row">
                <div class="col" style="padding-left:0;">
                    <% String address=""+user.getAdr_apt_name()+", Room no."+user.getAdr_room_no()+", floor."+user.getAdr_floor_no()+", LM:"+user.getAdr_landmark()+" "+user.getAdr()+" "+user.getAdr_city()+" ,"+user.getAdr_zip_code();
             out.print(address);         %>sai prasad society E5:104 near mahatma school 410206 new panvel
                </div>
                <div class="col text-right"><button class="btn">Change Address</button></div>
            </div>
            <hr>
            
            <div class="row">
                <div class="col" style="padding-left:0;">Total <%=total_num_pro%> items</div>
                <div class="col text-right">&#x20B9; <%=dao.gettotalprice(products) %>.00</div>
            </div>
            <div class="row">
                <div class="col" style="padding-left:0;">Shipping cost</div>
                <div class="col text-right">&#x20B9; 10.00</div>
            </div>
            
            <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                <div class="col">TOTAL PRICE</div>
                <div class="col text-right">&#x20B9; <%=dao.gettotalprice(products)+10 %>.00</div>
            </div> <a href="addorderservlet?cartid=<%=dao.getCartIdByUser(user)%>" class="btn">CHECKOUT</a>
        </div>
    </div>
</div>
        <!--gel cart products-->
         
        
     
          
      
          <br>
          
          Shipping on this address<br>
          
          
          
      
        <%
                                        }else{

out.print("your cart is empty");
}

 %>
        
       
       
   
    </body>
    
</html>
