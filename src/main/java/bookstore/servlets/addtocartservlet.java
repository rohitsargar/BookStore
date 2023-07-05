/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.servlets;

import bookstore.Dao.CartDao;
import bookstore.Dao.ProductDao;
import bookstore.entities.User;
import bookstore.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class addtocartservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            int proid=Integer.parseInt(request.getParameter("productid"));
            User user=(User) request.getSession().getAttribute("currentuser");
            
            
            ProductDao prodao=new ProductDao(ConnectionProvider.getConnection());
            if(Integer.parseInt(prodao.getProductByid(proid).getProduct_quantity())<=0) {
            	 out.println("Out of stock !");
            	
            }else {
            
            CartDao dao=new CartDao(ConnectionProvider.getConnection());
            int cartid=dao.getCartIdByUser(user);
            String rs=dao.productaddtocart(cartid, proid);
            if(rs.equals("done")){
                out.println("done");
//                response.sendRedirect("profile.jsp");
            
            }else if(rs.equals("exist")){
                out.println("exist");
//                response.sendRedirect("profile.jsp");
            }else{
                out.println("error");
//                response.sendRedirect("profile.jsp");
            }
            
            }
          
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
