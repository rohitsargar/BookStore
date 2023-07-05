/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.servlets;

import bookstore.Dao.CartDao;
import bookstore.Dao.OrdersDao;
import bookstore.Dao.ProductDao;
import bookstore.Dao.UserDao;
import bookstore.entities.CartProducts;
import bookstore.entities.Product;
import bookstore.entities.User;
import bookstore.entities.orders;
import bookstore.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class addorderservlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
//            get cart id
            int cart_id=Integer.parseInt(request.getParameter("cartid"));
            
            
//            get user id from cart id
            CartDao dao=new CartDao(ConnectionProvider.getConnection());
            int user_id=dao.getUserIdByCartId(cart_id);
            
            
//            get user from user id
            
            UserDao udao= new UserDao(ConnectionProvider.getConnection());
            User user=udao.getUserByid(user_id);
            
            
            ArrayList<CartProducts> cartpro=dao.getAllUserCartProducts(cart_id);
            ProductDao prodao=new ProductDao(ConnectionProvider.getConnection());
            OrdersDao odao=new OrdersDao(ConnectionProvider.getConnection());
            for(CartProducts orderpro:cartpro){
                
                Product pro = prodao.getProductByid(orderpro.getProduct_id()) ;
                String user_name=user.getName();
        
                String order_address="RM:"+user.getAdr_room_no()+"FL"+user.getAdr_floor_no()+"AP:"+user.getAdr_apt_name()+"LM:"+user.getAdr_landmark()+"ADL2:"+user.getAdr()+"CT:"+user.getAdr_city()+"ZP:"+String.valueOf(user.getAdr_zip_code());
                
              String pro_tot=String.valueOf(Integer.parseInt(pro.getProduct_price())*orderpro.getProduct_quantity())  ;
                orders order = new orders();
                
 //                       public orders(int user_id, String user_name, String user_address, int product_id, String product_name, String product_price, String product_quantity, String product_total, String product_status) {
 
               order.setUser_id(user_id);
               order.setUser_name(user_name);
               order.setUser_address(order_address);
               order.setProduct_id(orderpro.getProduct_id());
               order.setProduct_name(pro.getProduct_title());
               order.setProduct_price(pro.getProduct_price());
               order.setProduct_quantity(String.valueOf(orderpro.getProduct_quantity()));
               order.setProduct_total(pro_tot);
               order.setProduct_status("pending");
               
               if(odao.checkQuanAvl(Integer.parseInt(pro.getProduct_id()), orderpro.getProduct_quantity())) {
            	   if(odao.save_order(order)){
                       out.print("order save successfully");
                       
                       }else{
                               out.print("data not save");
                               }
            	   
            	   odao.decreaseProQuan(Integer.parseInt(pro.getProduct_id()), orderpro.getProduct_quantity());
            	   
               }else {
            	   out.print("Only "+pro.getProduct_quantity()+" books available..!");
            	   
               }

                
               
                
            
            
            
            }
            
            
           
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
