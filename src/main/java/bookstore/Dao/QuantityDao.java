/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Dao;
import bookstore.helper.ConnectionProvider;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class QuantityDao {
    private Connection con;

    public QuantityDao(Connection con) {
        this.con = con;
    }
    
    public int getquantity(int id){
        int qt=0;
        try {
        String query="select * from cart_Products where id="+id+"; ";
        PreparedStatement pstmt=this.con.prepareStatement(query);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            qt=rs.getInt("product_quantity");
        
        }
        }catch ( Exception e){
            e.printStackTrace();
        
        }
    
    
    return qt;
    }
    
    public boolean managequatity(int id,int qt){
        boolean f=false;
        try {
        String query="UPDATE cart_products SET product_quantity = "+qt+"  WHERE id ="+id;
        PreparedStatement pstmt=this.con.prepareStatement(query);
        pstmt.executeUpdate();
        f=true;
        
        }catch ( Exception e){
            e.printStackTrace();
        
        }
    
    
    return f;
    }
    
    
    
    
    
}
