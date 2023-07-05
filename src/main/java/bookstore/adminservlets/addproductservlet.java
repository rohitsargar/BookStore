/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.adminservlets;

import bookstore.Dao.ProductDao;
import bookstore.entities.Product;
import bookstore.helper.ConnectionProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class addproductservlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String   product_title             =request.getParameter("product_title");
            String   product_price             =request.getParameter("product_price");
            Part     part                      =request.getPart("product_image");
            String   product_image             =part.getSubmittedFileName();
            String   product_discount          =request.getParameter("product_discount");
            String   product_quantity          =request.getParameter("product_quantity");
            String   product_description       =request.getParameter("product_description");
            
            ProductDao dao=new ProductDao(ConnectionProvider.getConnection());
            
            Product products=new Product(product_title, product_price, product_image, product_discount, product_quantity, product_description);
            
            if(dao.saveProduct(products))
            {
                
                out.print("done");
                
                
                
                // image uploading start
           // find out the path to loded picture
           String  path = request.getRealPath("IMG")+File.separator+"products"+File.separator+product_image;
           System.out.println(path);
           
           // uploading image
           FileOutputStream fos=new FileOutputStream(path);
           InputStream fis=part.getInputStream();
           
              //reading data
              
              
              byte []data=new byte[fis.available()];
              
              fis.read(data);
              fos.write(data);
              fos.close();
                 // image uploading end


                
            }
            else{
                          out.print("something went wrong");
                      
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
