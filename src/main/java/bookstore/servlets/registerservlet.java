/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.servlets;

import bookstore.Dao.UserDao;
import bookstore.entities.Message;
import bookstore.entities.User;
import bookstore.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@MultipartConfig
public class registerservlet extends HttpServlet {

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
           
            
            String check=request.getParameter("user_check");
            if(check==null){
            out.print("box not checked");
            }
            else{
                  String   name=request.getParameter("user_name");
                  String      phone_no=request.getParameter("user_phonenum");
                  String   email_adr=request.getParameter("user_email");
                  String   password=request.getParameter("user_password");
                  String   adr_room_no=request.getParameter("user_addrrno");
                  String   adr_floor_no=request.getParameter("user_addrfno");
                  String   adr_apt_name=request.getParameter("user_addrbn");
                  String   adr=request.getParameter("user_addrar");
                  String   adr_landmark=request.getParameter("user_addrlm");
                  String   adr_city=request.getParameter("user_addrct");
                  int      adr_zip_code=Integer.parseInt(request.getParameter("user_addrzp"));
                  String   user_des=request.getParameter("user_descp");
                  
                  //String   user_check=request.getParameter("user_check");
                  UserDao dao=new UserDao(ConnectionProvider.getConnection());
                  
                  
                  User user=new User(name ,phone_no ,email_adr ,password ,adr_room_no ,adr_floor_no ,adr_apt_name ,adr ,adr_landmark ,adr_city ,adr_zip_code ,user_des);
                  
                  
                    if(dao.RegisterUserEmailExist(email_adr)){
                          out.print("user already exist");
                          
                      
                      }else if(dao.saveUser(user))
                      {
                      out.print("done");
                      }else{
                          out.print("semething went wrong");
                      
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
